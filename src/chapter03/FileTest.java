package chapter03;

import java.io.*;

public class FileTest {
	public static void main(String[] args) {
		FileInputStream fis = null;
		try {
			
			fis  = new FileInputStream("./hello.txt");
			int data = fis.read();
			
		} catch (IOException ioex) {
			
			ioex.printStackTrace();
			return;
			
		} finally {
			
			//사용한 리소스 정리
			try {
				
				if(fis != null) {
					fis.close();
				}
				
			} catch (IOException e) {
				
				e.printStackTrace();
				
			}
		}
		
		System.out.println("some code...");
	}
}
//jdbc,io,network에서 checked exception이 발생한다.