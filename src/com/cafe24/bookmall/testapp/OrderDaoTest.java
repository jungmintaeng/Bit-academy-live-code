package com.cafe24.bookmall.testapp;

import java.util.List;

import com.cafe24.bookmall.dao.OrderDao;
import com.cafe24.bookmall.vo.OrderVo;

public class OrderDaoTest {
	public static void main(String[] args) {
		getListTest();
	}
	
	private static void getListTest() {
		OrderDao dao = new OrderDao();
		List<OrderVo> vos = dao.getList();
		for(OrderVo vo : vos) {
			System.out.println(vo);
		}
	}
}
