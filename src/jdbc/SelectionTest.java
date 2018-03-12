package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectionTest {
	public static void main(String[] args) {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			String url="jdbc:mysql://localhost/dev";
			Class.forName("com.mysql.jdbc.Driver");
			//Class.forName("com.cafe24.jdbc.MyDriver");
			//conn = DriverManager.getConnection("asdasdsad", "dev", "dev");
			conn = DriverManager.getConnection(url, "dev", "dev");
			System.out.println("연결 성공");
			st = conn.createStatement();
			rs = st.executeQuery("select no, name, password, email, juminbunho, dept_name, date_format(join_date, '%Y-%m-%d')"
										+ " from user");
			
			//결과
			while(rs.next()) {/*
				System.out.println(rs.getInt("no"));
				System.out.println(rs.getString("name"));
				System.out.println(rs.getString("password"));
				System.out.println(rs.getString("email"));
				System.out.println(rs.getString("juminbunho"));
				System.out.println(rs.getString("dept_name"));
				System.out.println(rs.getString("join_date"));*/
				for(int i = 1 ; i <= 7; i++) {
					System.out.println(rs.getString(i));
				}
			}
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
			try {
				if(st != null && !st.isClosed())
					st.close();
			} catch (SQLException sqlex) {
				System.out.println("SQL ERROR !\n" + sqlex);
			}
			try {
				if(rs != null && !rs.isClosed())
					rs.close();
			} catch (SQLException sqlex) {
				System.out.println("SQL ERROR !\n" + sqlex);
			}
		}
	}
}
