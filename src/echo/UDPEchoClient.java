package echo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.util.Scanner;

public class UDPEchoClient {
	private static final String SERVER_IP = "192.168.1.17";
	private static final int SERVER_PORT = 5000;
	private static final int BUFFER_SIZE = 1024;
	public static void main(String[] args) {
		/**
		 * UDP에서는 ACK를 응용프로그램에서 구현해주어야 한다.
		 * 하지만 TCP보다 성능이 빠를 수 있다.
		 */
		DatagramSocket socket = null;
		Scanner sc = null;
		
		try {
			sc = new Scanner(System.in);
			socket = new DatagramSocket();
			
			while(true) {
				//TODO : Socket Operation
				System.out.print(">> ");
				String message = sc.nextLine();
				
				if("".equals(message)) {
					continue;
				}
				
				if("quit".equals(message)) {
					break;
				}
				
				//전송 패킷 생성
				byte[] sendData = message.getBytes("utf-8");
				DatagramPacket sendPacket = new DatagramPacket(sendData, 
						sendData.length, 
						new InetSocketAddress(SERVER_IP, SERVER_PORT));
				
				//전송
				socket.send(sendPacket);
				
				//5. 메시지 수신
				DatagramPacket receivePacket = new DatagramPacket(new byte[BUFFER_SIZE], BUFFER_SIZE);
				socket.receive(receivePacket);
				
				message = new String(receivePacket.getData(), 0, receivePacket.getLength(), "utf-8");
				System.out.println("<< " + message);
			}
		} catch (SocketException e) {
			e.printStackTrace();
		} catch(IOException e){
			e.printStackTrace();
		}finally {
			sc.close();
		}
	}
}
