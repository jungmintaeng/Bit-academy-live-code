package com.cafe24.hr.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cafe24.hr.vo.EmployeesVo;

public class EmployeesDao {
	private static final int LIST_COUNT = 100;
	
	public boolean updateEmployee(EmployeesVo vo) {
		Connection conn = null;
		PreparedStatement pst = null;
		int resultCount = -1;
		
		try {
			String sql="update employees" + 
						"    set birth_date= date_format(?, '%Y-%m-%d'), "
								+ "first_name = ?, "
								+ "last_name = ?, "
								+ "gender = ?, "
								+ "hire_date = date_format(?, '%Y-%m-%d')" + 
							" where emp_no = ?;";
			
			conn = getConnection();
			pst = conn.prepareStatement(sql);
			pst.setString(1, vo.getBirthDate());
			pst.setString(2, vo.getFirstName());
			pst.setString(3, vo.getLastName());
			pst.setString(4, vo.getGender());
			pst.setString(5, vo.getHireDate());
			pst.setLong(6, vo.getEmpNo());
			
			resultCount = pst.executeUpdate();
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
		}
		return resultCount==1;
	}
	
	public List<EmployeesVo> getList(int page){
		List<EmployeesVo> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		Long empNo;
		String birthDate, firstName, lastName, gender, hireDate;
		EmployeesVo vo;
		
		try {
			String sql="select emp_no,"
					+ "		date_format(birth_date, '%Y-%m-%d'), "
					+ "		first_name, last_name, gender, "
					+ "		date_format(hire_date, '%Y-%m-%d')" + 
					"		from employees" + 
					"		order by hire_date" + 
					"		limit ?, ?";
			conn = getConnection();
			
			pst = conn.prepareStatement(sql);
			pst.setInt(1, (page-1) * LIST_COUNT);
			pst.setInt(2, LIST_COUNT);
			rs = pst.executeQuery();
			while(rs.next()) {
				empNo = rs.getLong(1);
				birthDate = rs.getString(2);
				firstName = rs.getString(3);
				lastName = rs.getString(4);
				gender = rs.getString(5);
				hireDate = rs.getString(6);
				
				vo = new EmployeesVo();
				vo.setEmpNo(empNo);
				vo.setBirthDate(birthDate);
				vo.setFirstName(firstName);
				vo.setLastName(lastName);
				vo.setGender(gender);
				vo.setHireDate(hireDate);
				
				list.add(vo);
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
		return list;
	}

	private Connection getConnection() throws SQLException, ClassNotFoundException {
		Connection conn;
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost/employees", "hr", "hr");
		return conn;
	}
}
