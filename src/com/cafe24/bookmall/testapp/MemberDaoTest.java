package com.cafe24.bookmall.testapp;

import java.util.List;

import com.cafe24.bookmall.dao.MemberDao;
import com.cafe24.bookmall.vo.MemberVo;

public class MemberDaoTest {

	public static void main(String[] args) {
		getListTest();
	}
	
	private static void getListTest() {
		MemberDao dao = new MemberDao();
		List<MemberVo> vos = dao.getList();
		for(MemberVo vo : vos) {
			System.out.println(vo);
		}
	}
}
