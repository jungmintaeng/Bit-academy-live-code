package com.cafe24.paint.point;

import com.cafe24.paint.i.Drawable;

public class Point implements Drawable{
	private int x;
	private int y;
	
	/**
	 * Constructor
	 */
	public Point() {
		
	}
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * getter-setter
	 */
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	/**
	 * methods
	 */
	public void show() {
		//TODO : use graphic libraries
		System.out.println("점[" + x + "," + y + "]을 그렸습니다.");
	}
	
	public void show(boolean v) {
		if(v)
			show();
		else
			System.out.println("점[" + x + "," + y + "]을 지웠습니다.");
	}
	
	@Override
	public void draw() {
		
	}
	
	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}
}
