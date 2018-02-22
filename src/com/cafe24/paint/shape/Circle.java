package com.cafe24.paint.shape;

public class Circle extends Shape{
	private int radius;
	
	public Circle(int radius) {
		this.radius = radius;
	}
	
	
	/**
	 * getter-setter
	 */
	
	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}
	
	/**
	 * methods
	 */
	
	@Override
	public void draw() {
		System.out.println("원을 그렸습니다.");
	}
}
