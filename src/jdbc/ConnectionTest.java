package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 
 * JDBC는 INTERFACE 활용의 좋은 예
 * mysql에서 구현한 구현 클래스가 com.mysql.jdbc 패키지에 들어있다.
 *
 */

public class ConnectionTest {
	public static void main(String[] args) {
		Connection conn = null;
		
		try {
			String url="jdbc:mysql://localhost/dev";
			Class.forName("com.mysql.jdbc.Driver");
			//Class.forName("com.cafe24.jdbc.MyDriver");
			//conn = DriverManager.getConnection("asdasdsad", "dev", "dev");
			conn = DriverManager.getConnection(url, "dev", "dev");
			System.out.println("연결 성공");
		}catch(ClassNotFoundException cex) {
			System.out.println("드라이버 로드 실패!");
		} catch(SQLException sqlex){
			System.out.println("SQL ERROR !\n" + sqlex);
		} finally {
			try {
				if(conn != null && !conn.isClosed())
					conn.close();
			}catch (SQLException sqlex) {
				System.out.println("SQL ERROR !\n" + sqlex);
			}
		}
	}
}
