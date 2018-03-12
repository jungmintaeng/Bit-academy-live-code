package com.cafe24.music.vo;

public class CompanyVo {
	private long no;
	private int name;
	private int phone_number;

	public long getNo() {
		return no;
	}

	public void setNo(long no) {
		this.no = no;
	}

	public int getName() {
		return name;
	}

	public void setName(int name) {
		this.name = name;
	}

	public int getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(int phone_number) {
		this.phone_number = phone_number;
	}
	
	@Override
	public String toString() {
		return "CompanyVo [no=" + no + ", name=" + name + ", phone_number=" + phone_number + "]";
	}
}
