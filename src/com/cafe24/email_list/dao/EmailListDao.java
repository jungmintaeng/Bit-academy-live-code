package com.cafe24.email_list.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.cafe24.email_list.vo.EmailListVo;

public class EmailListDao {
	/**
	 * 		private Long no;
	private String first_name;
	private String last_name;
	private String email;
	 */
	
	public List<EmailListVo> getList(){
		List<EmailListVo> vos = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		EmailListVo vo = null;
		long no;
		String first_name, last_name, email;
		
		try {
			String sql = "SELECT NO, FIRST_NAME, LAST_NAME, EMAIL "
					+ "		FROM EMAIL_LIST "
					+ "		ORDER BY NO DESC";
			
			conn = WebDBAccess.getInstance().getConnection();
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			
			while(rs.next()) {
				no = rs.getLong(1);
				first_name = rs.getString(2);
				last_name = rs.getString(3);
				email = rs.getString(4);
				vo = new EmailListVo(no, first_name, last_name, email);
				vos.add(vo);
			}
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null && !rs.isClosed())
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}			
			try {
				if(pst != null && !pst.isClosed())
					pst.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(conn != null && !conn.isClosed())
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return vos;
	}
	
	public boolean insert(EmailListVo vo) {
		boolean result = false;
		Connection conn = null;
		PreparedStatement pst = null;
		
		try {
			String insertSQL = "INSERT INTO EMAIL_LIST(NO, FIRST_NAME, LAST_NAME, EMAIL)"
					+ " VALUES(?,?,?,?)";
			conn = WebDBAccess.getInstance().getConnection();
			pst = conn.prepareStatement(insertSQL);
			pst.setNull(1, Types.INTEGER);
			pst.setString(2, vo.getFirst_name());
			pst.setString(3, vo.getLast_name());
			pst.setString(4, vo.getEmail());
			result = pst.executeUpdate() > 0;
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pst != null && !pst.isClosed())
					pst.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			try {
				if(conn != null && !conn.isClosed())
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
}
