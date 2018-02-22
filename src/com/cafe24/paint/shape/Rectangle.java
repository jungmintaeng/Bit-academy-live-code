package com.cafe24.paint.shape;

public class Rectangle extends Shape{
	private int witdh;
	private int height;
	
	public Rectangle(int width, int height) {
		this.witdh = width;
		this.height = height;
	}
	
	/**
	 * getter - setter
	 */

	public int getWitdh() {
		return witdh;
	}

	public void setWitdh(int witdh) {
		this.witdh = witdh;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}


	/**
	 * methods
	 */
	
	@Override
	public void draw() {
		System.out.println("사각형을 그렸습니다.");
	}
}
