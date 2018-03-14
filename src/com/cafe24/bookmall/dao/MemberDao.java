package com.cafe24.bookmall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.cafe24.bookmall.vo.MemberVo;

public class MemberDao {
	public List<MemberVo> getList(){
		List<MemberVo> vos = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		MemberVo vo;
		// In vo
		Long no;
		String name;
		String phone_number;
		String email;
		String password;
		
		
		try {
			String sql="select no, name, phone_number, email, password" + 
					"		from member;";	
			conn = BookMallAccess.getInstance().getConnection();
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()) {				
				vo = new MemberVo();
				no = rs.getLong(1);
				name = rs.getString(2);
				phone_number = rs.getString(3);
				email = rs.getString(4);
				password = rs.getString(5);
				vo.setNo(no);
				vo.setName(name);
				vo.setPhoneNumber(phone_number);
				vo.setEmail(email);
				vo.setPassword(password);
				vos.add(vo);
			}
		}catch(ClassNotFoundException cex) {
			System.out.println("드라이버 로드 실패!" + cex);
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
	
	public boolean insert(MemberVo vo) {
		boolean result = false;
		Connection conn = null;
		PreparedStatement pst = null;
		
		try {
			String insertSQL = "INSERT INTO MEMBER(NO, NAME, PHONE_NUMBER, EMAIL, PASSWORD)"
					+ " VALUES(?,?,?,?,PASSWORD(?))";
			conn = BookMallAccess.getInstance().getConnection();
			pst = conn.prepareStatement(insertSQL);
			pst.setNull(1,  Types.INTEGER);
			pst.setString(2, vo.getName());
			pst.setString(3, vo.getPhoneNumber());
			pst.setString(4, vo.getEmail());
			pst.setString(5, vo.getPassword());
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
