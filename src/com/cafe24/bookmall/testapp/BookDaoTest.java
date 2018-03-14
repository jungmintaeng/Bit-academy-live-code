package com.cafe24.bookmall.testapp;

import java.util.List;

import com.cafe24.bookmall.dao.BookDao;
import com.cafe24.bookmall.vo.BookVo;

public class BookDaoTest {

	public static void main(String[] args) {
		getListTest();
	}
	
	private static void getListTest() {
		BookDao dao = new BookDao();
		List<BookVo> vos = dao.getList();
		for(BookVo vo : vos) {
			System.out.println(vo);
		}
	}
}
