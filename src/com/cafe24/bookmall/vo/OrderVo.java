package com.cafe24.bookmall.vo;

import java.util.List;

public class OrderVo {
	private Long no;
	private String code;
	private String address;
	private Long member_no;
	
	private String memberName;
	private String memberEmail;
	private int price;
	private List<OrderedBook> books;
	
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getMemberEmail() {
		return memberEmail;
	}
	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public List<OrderedBook> getBooks() {
		return books;
	}
	public void setBooks(List<OrderedBook> books) {
		this.books = books;
	}
	
	public String getOrderedBooks() {
		StringBuilder builder = new StringBuilder();
		for (OrderedBook book : books) {
			builder.append("책번호:  ");
			builder.append(book.no);
			builder.append(" / 책제목: ");
			builder.append(book.title);
			builder.append(" / 당시 책 가격: ");
			builder.append(book.price_old);
			builder.append(" / 수량: ");
			builder.append(book.quantity);
			builder.append("\n");
		}
		return builder.toString();
	}
	
	public void addOrderedBooks(Long no, String title, int quantity, int price_old) {
		OrderedBook insertObject= new OrderedBook(no, title, quantity, price_old);
		if( ! books.contains(insertObject)) {
			books.add(insertObject);
		}
	}
	
	public void deleteOrderedBooks(Long no) {
		for(OrderedBook book : books) {
			if(book.no == no) {
				books.remove(book);
				return;
			}
		}
	}
	
	private class OrderedBook {
		public Long no;
		public String title;
		public int quantity;
		public int price_old;
		
		public OrderedBook(Long no, String title, int quantity, int price_old) {
			this.no= no;
			this.title = title;
			this.quantity = quantity;
			this.price_old = price_old;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + ((no == null) ? 0 : no.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			OrderedBook other = (OrderedBook) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (no == null) {
				if (other.no != null)
					return false;
			} else if (!no.equals(other.no))
				return false;
			return true;
		}

		private OrderVo getOuterType() {
			return OrderVo.this;
		}
	}



	@Override
	public String toString() {
		return "OrderVo [no=" + no + ", code=" + code + ", address=" + address + ", memberName=" + memberName
				+ ", memberEmail=" + memberEmail + ", price=" + price + ", books=" + books + "]\nordered_books\n" + getOrderedBooks();
	}
	public Long getMember_no() {
		return member_no;
	}
	public void setMember_no(Long member_no) {
		this.member_no = member_no;
	}
}
