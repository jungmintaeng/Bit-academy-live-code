package chat;
import java.io.IOException;
import java.util.Scanner;

public class ChatClientApp {
	private static String SERVER_IP = "192.168.1.17";
	private static int SERVER_PORT = 8088;
	
	public static void main(String[] args) {
		String name = null;
		Scanner scanner = new Scanner(System.in);

		while( true ) {
			
			System.out.println("대화명을 입력하세요.");
			System.out.print(">>> ");
			name = scanner.nextLine();
			
			if (name.isEmpty() == false ) {
				break;
			}
			
			System.out.println("대화명은 한글자 이상 입력해야 합니다.\n");
		}
		
		scanner.close();

		try {
			new ChatWindow(name).show();
		} catch (IOException e) {
			System.out.println("죄송합니다. 연결에 실패하였습니다.");
			return;
		}
	}

	public static String getSERVER_IP() {
		return SERVER_IP;
	}

	public static void setSERVER_IP(String sERVER_IP) {
		SERVER_IP = sERVER_IP;
	}

	public static int getSERVER_PORT() {
		return SERVER_PORT;
	}

	public static void setSERVER_PORT(int sERVER_PORT) {
		SERVER_PORT = sERVER_PORT;
	}
}
