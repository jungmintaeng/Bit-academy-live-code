package com.cafe24.paint.shape;

import com.cafe24.paint.i.Drawable;

public abstract class Shape implements Drawable{
	private int area;
	private int perimeter;
	
	/**
	 * getter - setter
	 */
	
	public int getArea() {
		return area;
	}
	public void setArea(int area) {
		this.area = area;
	}
	public int getPerimeter() {
		return perimeter;
	}
	public void setPerimeter(int perimeter) {
		this.perimeter = perimeter;
	}
}
