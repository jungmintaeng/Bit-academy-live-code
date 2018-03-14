package com.cafe24.bookmall.testapp;

import java.util.List;

import com.cafe24.bookmall.dao.CategoryDao;
import com.cafe24.bookmall.vo.CategoryVo;

public class CategoryDaoTest {

	public static void main(String[] args) {
		getListTest();
	}
	
	private static void getListTest() {
		CategoryDao dao = new CategoryDao();
		List<CategoryVo> vos = dao.getList();
		for(CategoryVo vo : vos) {
			System.out.println(vo);
		}
	}
}
