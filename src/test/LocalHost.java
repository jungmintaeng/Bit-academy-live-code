package test;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class LocalHost {

	public static void main(String[] args) {
		try {
			InetAddress inetAddress = InetAddress.getLocalHost();
			String hostName = inetAddress.getHostName(); //www.naver.com 이면 www를 찾아옴
			String hostAddress = inetAddress.getHostAddress();
			byte[] addresses = inetAddress.getAddress();
			System.out.println(hostName + "\n" + hostAddress);
			for (int i = 0; i < addresses.length ; i++) {
				System.out.print((addresses[i] & 0x000000ff) + (i == addresses.length - 1? "" : "."));
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
}
