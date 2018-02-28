package chat;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Vector;

/**
 *=========== 명세서===========
 * Accept하고 있는 main server가 하나 있고
 * 채팅은 client들이 하는 형태
 * 메시지 부분은 Base64로 encoding
 * 출력할 때에는 Base64로 decoding 후 출력해야 한다.
 */

public class ChatServer {
	private static String SERVER_IP = "192.168.1.17";
	private static int SERVER_PORT = 8088;
	private static List<PrintWriter> observers = new Vector<>();

	public static String getServerIp() {
		return SERVER_IP;
	}
	public static int getServerPort() {
		return SERVER_PORT;
	}

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		Socket socket = null;

		try {
			serverSocket = new ServerSocket();
			serverSocket.bind(new InetSocketAddress(SERVER_IP, SERVER_PORT));

			while(true) {
				socket = serverSocket.accept();
				new ChatServerProcessThread(socket).start();
			}
		}catch(IOException ioex) {
			ioex.printStackTrace();
		}finally {
			if(serverSocket != null && ! serverSocket.isClosed()) {
				try {
					serverSocket.close();
				}catch(IOException ioex) {
					log("serverSocket close exception");
				}
			}
		}
	}

	private static void log(String message) {
		System.out.println("[Server] " + message);
	}

	public static void addObserver(PrintWriter newP) {
		observers.add(newP);
	}

	public static  void removeObserver(PrintWriter remP) {
		observers.remove(remP);
	}

	public static void broadcast(String message, PrintWriter writer) {
		int len = observers.size();
		for(int i = 0 ; i < len; i++) {
			if(!observers.get(i).equals(writer))
				observers.get(i).println(message);
		}
		
		System.out.println(message);
	}
}
