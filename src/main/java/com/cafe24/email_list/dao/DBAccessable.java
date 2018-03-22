package com.cafe24.email_list.dao;

import java.sql.Connection;
import java.sql.SQLException;

public interface DBAccessable {
	public Connection getConnection() throws SQLException, ClassNotFoundException;
}
