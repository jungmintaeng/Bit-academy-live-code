package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

public class InsertTest {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			String url="jdbc:mysql://localhost/dev";
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, "dev", "dev");
			
			String sql = "insert into pet("
					+ "name," + 
					"owner," + 
					"species," + 
					"gender," + 
					"birth," + 
					"death) values( "
					+ "?, ?, ?, ?, ?, ?)";
			
			pst = conn.prepareStatement(sql);
			
			String name = "삽살이";
			String owner = "삽살주인";
			String species = "sapsal";
			String gender = "F";
			String birth = "2009-02-02";
			
			pst.setString(1, name);
			pst.setString(2, owner);
			pst.setString(3, species);
			pst.setString(4, gender);
			pst.setString(5, birth);
			pst.setNull(6, Types.DATE);
			
		}catch(ClassNotFoundException e) {
			System.out.println("드라이버 로드 실패");
		} catch(SQLException e) {
			System.out.println("SQL Exception : " + e);
		} finally {
			try {
				if(conn != null && !conn.isClosed())
					conn.close();
			}catch (SQLException sqlex) {
				System.out.println("SQL ERROR !\n" + sqlex);
			}
			try {
				if(pst != null && !pst.isClosed())
					pst.close();
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
