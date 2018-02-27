package test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class TCPServer {
	public static final int SERVER_PORT = 5000;
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		Socket socket = null;
		// 1. 서버 소켓 생성
		try {
			serverSocket = new ServerSocket();

			//바인딩
			String localhostAddress = InetAddress.getLocalHost().getHostAddress();
			serverSocket.bind(new InetSocketAddress(localhostAddress, SERVER_PORT));

			//3. 연결 요청 기다림(accept)
			socket = serverSocket.accept();

			//4. 연결 성공
			InetSocketAddress remoteSocketAddress = (InetSocketAddress)socket.getRemoteSocketAddress();
			int remoteHostPort = remoteSocketAddress.getPort();
			String remoteHostAddress = remoteSocketAddress.getAddress().getHostAddress();
			System.out.println("[Server] connected by " + remoteHostAddress + " port : " + remoteHostPort);

			try {
				//데이터 통신 - Socket 안에 있는 InputStream, OutputStream을 이용해서 함
				//5. I/O Stream 받아오기
				InputStream is = socket.getInputStream();
				OutputStream os = socket.getOutputStream();
				
				while(true) {
					//6. 데이터 읽기(read)
					byte[] buffer = new byte[256];
					int readByteCount = is.read(buffer);	//blocking 되어있음
					
					if(readByteCount <= -1) {	//client 측에서 정상적으로 close를 호출한 경우
						System.out.println("[Server] disconnected by client");
						break;
					}
					
					String data = new String(buffer, 0, readByteCount, "utf-8");
					System.out.println("[Server] received : " + data);
					
					//7. data 쓰기
					os.write(data.getBytes("utf-8"));
				}

			}catch(SocketException socex){	//client가 정상적으로 소켓을 닫지 않고 종료한 경우
				System.out.println("[Server] sudden closed by client");
			}catch(IOException ex) {
				ex.printStackTrace();
			}finally {
				if(socket != null && !socket.isClosed())
					socket.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
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
