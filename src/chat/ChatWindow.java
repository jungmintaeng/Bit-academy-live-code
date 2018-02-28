package chat;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ChatWindow {
	/**
	 * UI Components
	 */
	private Frame frame;
	private Panel pannel;
	private Button buttonSend;
	private TextField textField;
	private TextArea textArea;

	/**
	 * members
	 */
	private String nickName = null;
	private Socket socket = null;
	private PrintWriter writer = null;
	private BufferedReader reader = null;
	private Thread receiveThread = null;

	public ChatWindow(String name) throws IOException{
		this.nickName = name;
		frame = new Frame(name);
		pannel = new Panel();
		buttonSend = new Button("Send");
		textField = new TextField();
		textArea = new TextArea(30, 80);

		socket = new Socket();
		socket.connect(new InetSocketAddress(ChatClientApp.getSERVER_IP(), ChatClientApp.getSERVER_PORT()));
		reader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
		writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true);
		receiveThread = new ChatClientMessageReceiveThread();
		receiveThread.start();
		writer.println(ChatProtocol.makeMessage(ChatProtocol.JOIN, ChatProtocol.encode(nickName), null));
	}

	public void show() {
		// Button
		buttonSend.setBackground(Color.GRAY);
		buttonSend.setForeground(Color.WHITE);
		buttonSend.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed( ActionEvent actionEvent ) {
				sendMessage();
			}
		});


		// Textfield
		textField.setColumns(80);
		textField.addKeyListener( new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				char keyCode = e.getKeyChar();
				if (keyCode == KeyEvent.VK_ENTER) {
					sendMessage();
				}
			}
		});

		// Pannel
		pannel.setBackground(Color.LIGHT_GRAY);
		pannel.add(textField);
		pannel.add(buttonSend);
		frame.add(BorderLayout.SOUTH, pannel);

		// TextArea
		textArea.setEditable(false);
		frame.add(BorderLayout.CENTER, textArea);

		// Frame
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				if(receiveThread != null && receiveThread.isAlive()) {
					receiveThread.interrupt();
				}
				writer.println(ChatProtocol.makeMessage(ChatProtocol.EXIT, nickName, null));
				System.exit(0);
			}
		});
		frame.setVisible(true);
		frame.pack();
	}

	private void sendMessage() {
		String message = textField.getText();
		if("quit".equals(message)) {
			writer.println(ChatProtocol.makeMessage(ChatProtocol.EXIT, nickName, null));
			System.exit(0);
		}

		textArea.append( nickName + " >> " + message );
		textArea.append("\n");

		textField.setText("");
		textField.requestFocus();		

		writer.println(ChatProtocol.makeMessage(ChatProtocol.MESSAGE, nickName, 
				ChatProtocol.encode(message)));
	}

	private class ChatClientMessageReceiveThread extends Thread{
		@Override
		public void run() {
			String serverMessage;
			try {
				while(true) {
					serverMessage = reader.readLine();
					if(serverMessage == null) {
						//연결이 끊어짐
						System.out.println("서버와의 연결이 끊어졌습니다.");
						System.exit(-1);
					}
					textArea.append(serverMessage + "\n");
				}
			}catch(ConnectException cex) {
				System.out.println("연결이 끊어졌습니다.");
				System.exit(-1);
			}catch(IOException ioex) {
				System.out.println("서버와의 연결이 끊어졌습니다.");
				System.exit(-1);
			}
			finally {
				try {
					reader.close();
				} catch (IOException e) {
					System.out.println("client reader close exception");
				}
				writer.close();

				if(socket != null && ! socket.isClosed()) {
					try {
						socket.close();
					}catch(IOException ioex) {
						System.out.println("socket close exception");
					}
				}
			}
		}
	}
}
