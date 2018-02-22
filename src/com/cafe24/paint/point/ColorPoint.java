package com.cafe24.paint.point;

public class ColorPoint extends Point{
	private String color;
	
	/**
	 * Constructor
	 */
	
	public ColorPoint() {
		super();
	}
	
	public ColorPoint(String color) {
		this.color = color;
	}
	
	public ColorPoint(int x, int y, String color) {
		super(x,y);
		this.color = color;
	}
	
	/**
	 * getter-setter
	 */
	
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	/**
	 * methods
	 */
	@Override
	public void draw() {
		
	}
	
	@Override
	public void show() {
		System.out.println("점[" + getX() + "," + getY() + ", color=" + color +"]을 그렸습니다.");
	}
	
	@Override
	public void show(boolean display) {
		if(display) {
			show();
			return;
		}
		System.out.println("점[" + getX() + "," + getY() + ", color=" + color +"]을 지웠습니다.");
	}
}
