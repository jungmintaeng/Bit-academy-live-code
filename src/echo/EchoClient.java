package echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class EchoClient {
	private static final String SERVER_IP = "192.168.1.17";
	private static final int SERVER_PORT = 6000;
	public static void main(String[] args) {
		Socket socket = new Socket();
		Scanner scanner = new Scanner(System.in);
		try {
			socket.connect(new InetSocketAddress(SERVER_IP, SERVER_PORT));
			BufferedReader br = new BufferedReader(new InputStreamReader( socket.getInputStream(), "utf-8" ));
			PrintWriter pw = new PrintWriter( new OutputStreamWriter( socket.getOutputStream(), "utf-8" ), true);
			//true : auto flushing
			
			while(true) {
				System.out.print(">> ");
				String message = scanner.nextLine();
				if(message.equals("exit")) {
					break;
				}
				pw.println(message);
				
				String echoMessage = br.readLine();
				if(echoMessage == null) {
					System.out.println("disconnected from server");
					break;
				}
				
				System.out.println("<< " + echoMessage);
			}
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			scanner.close();
			if(socket != null && !socket.isClosed()) {
				try {
					socket.close();
				}catch(IOException ex) {
					ex.printStackTrace();
				}
			}
		}
	}
}
