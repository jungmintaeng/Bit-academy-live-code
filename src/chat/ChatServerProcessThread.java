package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class ChatServerProcessThread extends Thread{
	private Socket socket = null;
	private String nickName = null;
	
	public ChatServerProcessThread(Socket socket) {
		this.socket = socket;
	}
	
	@Override
	public void run() {
		BufferedReader reader = null;
		PrintWriter writer = null;
		String line = null;
		try {
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
			writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true);
			while(true) {
				line = reader.readLine();
				if(line == null) {
					//socket closed
					ChatServer.removeObserver(writer);
					ChatServer.broadcast(nickName + " 님이 퇴장하셨습니다.", writer);
					this.interrupt();
					break;
				}
				StringBuilder realMessage = new StringBuilder();
				String[] messageTokens = line.split(" ");
				switch(line.charAt(0)) {
				case ChatProtocol.JOIN:
					nickName = ChatProtocol.decode(messageTokens[1]);
					realMessage.append(nickName);
					realMessage.append(" 님이 입장하셨습니다.");
					ChatServer.addObserver(writer);
					ChatServer.broadcast(realMessage.toString(), writer);
					break;
				case ChatProtocol.MESSAGE:
					realMessage.append(nickName);
					realMessage.append(" >> ");
					if(messageTokens.length > 2) {
						realMessage.append(ChatProtocol.decode(messageTokens[2]));
					}
					ChatServer.broadcast(realMessage.toString(), writer);
					break;
				case ChatProtocol.EXIT :
					ChatServer.removeObserver(writer);
					ChatServer.broadcast(nickName + " 님이 퇴장하셨습니다.", writer);
					this.interrupt();
					break;
				default :
					System.out.println("잘못된 메시지 요청... 내용 : \n" + line);
					break;
				}
			}
		}catch(IOException ioex) {
			System.out.println("IOException occurred in Server Thread [" + nickName + "] - Connection lost");
		}finally {
			ChatServer.removeObserver(writer);
			try {
				reader.close();
			} catch (IOException e) {
				System.out.println("server reader close exception");
			}
			
			writer.close();
			
			if(socket != null && ! socket.isClosed()) {
				try {
					socket.close();
				}catch(IOException ioex) {
					System.out.println("server socket close exception");
				}
			}
		}
	}
}
