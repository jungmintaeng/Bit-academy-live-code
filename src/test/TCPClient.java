package test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.Scanner;

public class TCPClient {
	private static final String SERVER_IP = "192.168.1.17";
	
	public static void main(String[] args) {
		if(args.length != 1) {
			System.out.println("잘못된 인자입니다.");
			return;
		}
		final int SERVER_PORT = Integer.parseInt(args[0]);
		//final int SERVER_PORT = 5000;
		
		Socket socket = null;
		Scanner sc = new Scanner(System.in);
		
		try {
			//1. 소켓 생성
			socket = new Socket();
			
			//1-1. 소켓 타임아웃
			socket.setSoTimeout(3 * 1000);
			//1-2. Nagle 끄기 (SO_NODELAY)
			socket.setTcpNoDelay(true);
			//Nagle 켜기
			//socket.setTcpNoDelay(false);
			
			//2. 서버 연결
			socket.connect(new InetSocketAddress(SERVER_IP, SERVER_PORT));
			
			//2-2 Socket Buffer Size 확인
			int receiveBufferSize = socket.getReceiveBufferSize();
			int sendBufferSize = socket.getSendBufferSize();
			
			System.out.println("rec buf : " + receiveBufferSize + " , Send buf : " + sendBufferSize);
			
			//2-3 Socket Buffer Size 변경
			socket.setReceiveBufferSize(1024 * 10);
			socket.setSendBufferSize(1024 * 10);
			
			receiveBufferSize = socket.getReceiveBufferSize();
			sendBufferSize = socket.getSendBufferSize();
			
			System.out.println("After setting > rec buf : " + receiveBufferSize + " , Send buf : " + sendBufferSize);
			
			//3. I/O Stream 받아오기
			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();
			
			String data = sc.nextLine();
			os.write(data.getBytes("utf-8"));
			
			byte[] buffer = new byte[256];
			int readByteCount = is.read(buffer);
			if(readByteCount <= -1) {
				System.out.println("[Client] disconnected by server");
				return;
			}
			
			data = new String(buffer, 0, readByteCount, "utf-8");
			System.out.println("[Client] received : " + data);
		}catch(ConnectException e) {
			e.printStackTrace();
		}catch(SocketTimeoutException stoex) {
			stoex.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			if(socket != null && !socket.isClosed()) {
				try {
					socket.close();
				}catch(IOException ex) {
					ex.printStackTrace();
				}
			}
			sc.close();
		}
	}
}
