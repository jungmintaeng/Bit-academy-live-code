package echo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

public class UDPEchoServer {
	private static final int PORT = 5000;
	private static final int BUFFER_SIZE = 1024;
	
	public static void main(String[] args) {
		DatagramSocket dataSocket = null;
		
		try {
			//1. 소켓 생성
			dataSocket = new DatagramSocket(PORT);
			
			//2. 수신 패킷 생성
			DatagramPacket receivePacket = new DatagramPacket(new byte[BUFFER_SIZE], 
					BUFFER_SIZE);
			
			while(true) {
				//3. 데이터 수신 대기
				dataSocket.receive(receivePacket);	//blocking
				
				//4. 수신
				String message = new String(receivePacket.getData(), 0 , receivePacket.getLength(), "utf-8");
				log("received : " + message);
				
				//5. 데이터 송신
				byte[] sendData = message.getBytes("utf-8");
				DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length,
						new InetSocketAddress(receivePacket.getAddress(), receivePacket.getPort()));
				dataSocket.send(sendPacket);
			}
		}catch(SocketException socex) {
			socex.printStackTrace();
		}catch(IOException ioex) {
			ioex.printStackTrace();
		}finally {
			if(dataSocket != null && !dataSocket.isClosed()) {
				dataSocket.close();
			}
		}
	}
	
	private static void log(String msg) {
		System.out.println("[Echo Server]" + msg);
	}
}
