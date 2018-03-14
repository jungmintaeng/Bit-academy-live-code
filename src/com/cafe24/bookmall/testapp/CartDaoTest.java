package com.cafe24.bookmall.testapp;

import java.util.List;

import com.cafe24.bookmall.dao.CartDao;
import com.cafe24.bookmall.vo.CartVo;

public class CartDaoTest {

	public static void main(String[] args) {
		getListTest();
	}
	
	private static void getListTest() {
		CartDao dao = new CartDao();
		List<CartVo> vos = dao.getList();
		for(CartVo vo : vos) {
			System.out.println(vo);
		}
	}
}
