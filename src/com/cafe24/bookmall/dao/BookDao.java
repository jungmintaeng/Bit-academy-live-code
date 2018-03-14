package com.cafe24.bookmall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.cafe24.bookmall.vo.BookVo;

public class BookDao {
	
	public List<BookVo> getList(){
		List<BookVo> vos = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		BookVo vo;
		// In vo
		long no;
		String title;
		int price;
		String category;
		long category_no;
		/**
		 * 	private Long no;
	private String title;
	private int price;
	private Long category_no;
	
	private String category;
		 */
		try {
			String sql="select b.no, b.title, b.price, c.name, c.no" + 
					"		from book b" + 
					"		join category c on b.category_no = c.no";
			conn = BookMallAccess.getInstance().getConnection();
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()) {				
				vo = new BookVo();
				
				no = rs.getLong(1);
				title = rs.getString(2);
				price = rs.getInt(3);
				category = rs.getString(4);
				category_no = rs.getLong(5);
				
				vo.setNo(no);
				vo.setTitle(title);
				vo.setPrice(price);
				vo.setCategory(category);
				vo.setCategory_no(category_no);
				
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
	
	public boolean insert(BookVo vo) {
		boolean result = false;
		Connection conn = null;
		PreparedStatement pst = null;
		
		try {
			String insertSQL = "INSERT INTO BOOK(NO, TITLE, PRICE, CATEGORY_NO)"
					+ " VALUES(?,?,?,?)";
			conn = BookMallAccess.getInstance().getConnection();
			pst = conn.prepareStatement(insertSQL);
			pst.setNull(1, Types.INTEGER);
			pst.setString(2, vo.getTitle());
			pst.setInt(3, vo.getPrice());
			pst.setLong(4, vo.getCategory_no());
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
