package com.cafe24.music.vo;

public class AlbumVo {
	private long no;
	private String title;
	private int company_no;
	private int singer_no;
	
	public long getNo() {
		return no;
	}
	public void setNo(long no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getCompany_no() {
		return company_no;
	}
	public void setCompany_no(int company_no) {
		this.company_no = company_no;
	}
	public int getSinger_no() {
		return singer_no;
	}
	public void setSinger_no(int singer_no) {
		this.singer_no = singer_no;
	}
	
	@Override
	public String toString() {
		return "AlbumVo [no=" + no + ", title=" + title + ", company_no=" + company_no + ", singer_no=" + singer_no
				+ "]";
	}
}
