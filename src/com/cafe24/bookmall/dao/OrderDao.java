package com.cafe24.bookmall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.cafe24.bookmall.vo.MemberVo;
import com.cafe24.bookmall.vo.OrderVo;
import com.mysql.jdbc.Statement;

public class OrderDao {
	public List<OrderVo> getList(){
		List<OrderVo> vos = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pst_order = null, pst_books = null;
		ResultSet rs_order = null, rs_books = null;
		
		OrderVo vo;
		// In vo
		Long no;
		String code;
		String address;
		
		long member_no;
		String memberName;
		String memberEmail;
		int price;
		// booklist
		Long bno;
		String title;
		int quantity;
		int price_old;
		
		try {
			String sql_order="select o.no, o.code, o.address,m.name, m.email, (" + 
					"							select sum(ob.bookprice_old * ob.quantity)" + 
					"    						from order_book ob" + 
					"   						 where ob.order_no = o.no" + 
					" 				   ) price,  m.no" + 
					"					from order_sheet o" + 
					"					join member m on o.member_no = m.no";
			String sql_books="select b.no, b.title, ob.quantity, ob.bookprice_old" + 
					"					from order_book ob" + 
					"					join book b on ob.book_no=b.no" + 
					"					where order_no=?";
			conn = BookMallAccess.getInstance().getConnection();
			pst_books = conn.prepareStatement(sql_books);
			pst_order = conn.prepareStatement(sql_order);
			rs_order = pst_order.executeQuery();
			while(rs_order.next()) {
				no = rs_order.getLong(1);
				code = rs_order.getString(2);
				address = rs_order.getString(3);
				memberName = rs_order.getString(4);
				memberEmail = rs_order.getString(5);
				price = rs_order.getInt(6);
				member_no = rs_order.getLong(7);
				vo = new OrderVo();
				vo.setNo(no);
				vo.setCode(code);
				vo.setAddress(address);
				vo.setMemberName(memberName);
				vo.setMemberEmail(memberEmail);
				vo.setPrice(price);
				vo.setMember_no(member_no);
				pst_books.setLong(1, no);
				rs_books = pst_books.executeQuery();
				while(rs_books.next()) {
					bno = rs_books.getLong(1);
					title = rs_books.getString(2);
					quantity = rs_books.getInt(3);
					price_old = rs_books.getInt(4);
					vo.addOrderedBooks(bno, title, quantity, price_old);
				}
				
				pst_books.clearParameters();
				rs_books.close();
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
				if(pst_order != null && !pst_order.isClosed())
					pst_order.close();
			} catch (SQLException sqlex) {
				System.out.println("SQL ERROR !\n" + sqlex);
			}
			try {
				if(pst_books != null && !pst_books.isClosed())
					pst_books.close();
			} catch (SQLException sqlex) {
				System.out.println("SQL ERROR !\n" + sqlex);
			}
			try {
				if(rs_order != null && !rs_order.isClosed())
					rs_order.close();
			} catch (SQLException sqlex) {
				System.out.println("SQL ERROR !\n" + sqlex);
			}
			try {
				if(rs_books != null && !rs_books.isClosed())
					rs_books.close();
			} catch (SQLException sqlex) {
				System.out.println("SQL ERROR !\n" + sqlex);
			}
		}
		
		return vos;
	}
	
	public boolean insert(OrderVo vo) {
		boolean result = false;
		Connection conn = null;
		PreparedStatement pst = null;
		PreparedStatement pst_book = null;
		ResultSet rs = null;
		
		try {
			String insertSQL = "INSERT INTO ORDER_SHEET(NO, CODE, ADDRESS, MEMBER_NO)"
					+ " VALUES(?,?,?,?,PASSWORD(?))";
			String insertOrderBookSQL = "INSERT INTO ORDER_BOOK(ORDER_NO BOOK_NO QUANTITY BOOKPRICE_OLD)"
					+ "	VALUES(?,?,?,?)";
			conn = BookMallAccess.getInstance().getConnection();
			pst = conn.prepareStatement(insertSQL, Statement.RETURN_GENERATED_KEYS);
			pst.setNull(1,  Types.INTEGER);
			pst.setString(2,  vo.getCode());
			pst.setString(3,  vo.getAddress());
			pst.setLong(4,  vo.getMember_no());
			pst.executeUpdate();
			rs = pst.getGeneratedKeys();
			if(rs.next())
				vo.setNo(rs.getLong(1));
			else
				throw new SQLException("Failed to get Generated Key");
			pst_book = conn.prepareStatement(insertOrderBookSQL);
			pst_book.setLong(1, vo.getNo());
			result = pst.executeUpdate() > 0;
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch(SQLException e) {
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
				if(pst_book != null && !pst.isClosed())
					pst_book.close();
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
