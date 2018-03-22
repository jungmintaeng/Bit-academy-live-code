package com.cafe24.email_list.vo;

public class EmailListVo {
	private Long no;
	private String first_name;
	private String last_name;
	private String email;
	
	public EmailListVo() {
		
	}
	public EmailListVo(Long no, String first_name, String last_name, String email) {
		super();
		this.no = no;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
	}

	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "EmailListDao [no=" + no + ", first_name=" + first_name + ", last_name=" + last_name + ", email=" + email
				+ "]";
	}
}
