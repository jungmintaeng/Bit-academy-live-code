package com.cafe24.bookmall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cafe24.bookmall.vo.CartVo;

public class CartDao {
	public List<CartVo> getList(){
		List<CartVo> vos = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		CartVo vo;
		// In vo
		long member_no;
		long book_no;
		int quantity;
		
		int price;
		String title;
		
		try {
			String sql="select c.member_no, c.book_no, c.quantity, b.price, b.title" + 
					"		from cart c" + 
					"		join book b on c.book_no=b.no;";
			conn = BookMallAccess.getInstance().getConnection();
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()) {				
				vo = new CartVo();
				member_no = rs.getLong(1);
				book_no = rs.getLong(2);
				quantity = rs.getInt(3);
				price = rs.getInt(4);
				title = rs.getString(5);
				vo.setMember_no(member_no);
				vo.setBook_no(book_no);
				vo.setQuantity(quantity);
				vo.setPrice(price);
				vo.setTitle(title);
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
	
	public boolean insert(CartVo vo) {
		boolean result = false;
		Connection conn = null;
		PreparedStatement pst = null;
		
		try {
			String insertSQL = "INSERT INTO CART(MEMBER_NO, BOOK_NO, QUANTITY)"
					+ " VALUES(?,?,?)";
			conn = BookMallAccess.getInstance().getConnection();
			pst = conn.prepareStatement(insertSQL);
			pst.setLong(1,  vo.getMember_no());
			pst.setLong(2,vo.getBook_no());
			pst.setInt(3,  vo.getQuantity());
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
