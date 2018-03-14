package com.cafe24.bookmall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.cafe24.bookmall.vo.CategoryVo;

public class CategoryDao {
	
	public List<CategoryVo> getList(){
		List<CategoryVo> vos = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		long no;
		String name;
		CategoryVo vo;
		
		try {
			String sql="select no, name"
					+ "	from category";
			conn = BookMallAccess.getInstance().getConnection();
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()) {				
				vo = new CategoryVo();
				no = rs.getLong(1);
				name = rs.getString(2);
				vo.setNo(no);
				vo.setName(name);
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
	
	public boolean insert(CategoryVo vo) {
		boolean result = false;
		Connection conn = null;
		PreparedStatement pst = null;
		
		try {
			String insertSQL = "INSERT INTO CATEGORY(NO, NAME)"
					+ " VALUES(?,?)";
			conn = BookMallAccess.getInstance().getConnection();
			pst = conn.prepareStatement(insertSQL);
			pst.setNull(1,  Types.INTEGER);
			pst.setString(2,  vo.getName());
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
