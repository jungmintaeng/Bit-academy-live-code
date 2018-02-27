package echo;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketException;

public class EchoServerReceiveThread extends Thread{
	private Socket socket;
	
	public EchoServerReceiveThread(Socket socket) {
		this.socket = socket;
	}
	
	@Override
	public void run() {
		//3. 연결 요청 기다림(accept)
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
					consoleLog("disconnected by client");
					break;
				}
				
				String data = new String(buffer, 0, readByteCount, "utf-8");
				consoleLog("received : " + data);
				
				//7. data 쓰기
				os.write(data.getBytes("utf-8"));
			}

		}catch(SocketException socex){	//client가 정상적으로 소켓을 닫지 않고 종료한 경우
			consoleLog("sudden closed by client");
		}catch(IOException ex) {
			ex.printStackTrace();
		}finally {
			if(socket != null && !socket.isClosed())
				try {
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}
	
	private static void consoleLog(String log) {
		System.out.println("[Server : " + Thread.currentThread().getId() + "]");
	}
}
