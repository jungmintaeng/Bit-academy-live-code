package chat;

import org.apache.commons.codec.binary.Base64;

public class ChatProtocol {
	public static final char JOIN = 'J';
	public static final char MESSAGE = 'M';
	public static final char EXIT = 'E';
	
	public static String makeMessage(char type, String nickName, String message) {
		return String.valueOf(type) + " " + nickName + " " + message;
	}
	
	public static String encode(String s) {
		return Base64.encodeBase64String(s.getBytes());
	}
	
	public static String decode(String s) {
		return new String(Base64.decodeBase64(s));
	}
}
