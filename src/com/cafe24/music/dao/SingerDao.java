package com.cafe24.music.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.cafe24.music.vo.SingerVo;

public class SingerDao{
	
	public List<SingerVo> getList(){
		List<SingerVo> vos = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		long no;
		String name;
		SingerVo vo;
		
		try {
			String sql="select no, name from singer";
			conn = getConnection();
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()) {				
				vo = new SingerVo();
				
				vos.add(vo);
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
		
		
		return vos;
	}
	
	public boolean insert(SingerVo vo) {
		boolean result = false;
		Connection conn = null;
		PreparedStatement pst = null;

		try {
			conn =getConnection();
			String sql = "insert into singer values(null, ?)";

			pst = conn.prepareStatement(sql);
			pst.setString(1, vo.getName());

			int count = pst.executeUpdate();

			result = count==1;
		}catch(SQLException e) {
			e.printStackTrace();
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if( conn != null && !conn.isClosed()) {
					conn.close();
				} 
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return result;
	} 

	private Connection getConnection() throws SQLException, ClassNotFoundException {
		Connection conn;
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost/dev", "dev", "dev");
		return conn;
	}
}
