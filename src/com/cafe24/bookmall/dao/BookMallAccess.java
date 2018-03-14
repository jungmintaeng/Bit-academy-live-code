package com.cafe24.bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BookMallAccess implements DBAccessable{
	private static BookMallAccess instance = null;
	
	private BookMallAccess() {
		// Make Constructor Private
	}
	
	public static BookMallAccess getInstance() {
		synchronized(BookMallAccess.class) {
			if(instance == null) {
				instance = new BookMallAccess();
			}
			return instance;
		}
	}
	
	@Override
	public Connection getConnection() throws SQLException, ClassNotFoundException {
		Connection conn;
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost/bookmall", "bookmall", "bookmall");
		return conn;
	}
}
