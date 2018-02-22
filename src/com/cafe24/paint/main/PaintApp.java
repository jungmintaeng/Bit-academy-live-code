package com.cafe24.paint.main;

import com.cafe24.paint.i.Drawable;
import com.cafe24.paint.point.ColorPoint;
import com.cafe24.paint.point.Point;
import com.cafe24.paint.shape.Circle;
import com.cafe24.paint.shape.Rectangle;
import com.cafe24.paint.shape.Shape;

public class PaintApp {

	public static void main(String[] args) {
		Point p = new Point();
		p.setX(10);
		p.setY(5);
		p.show();
		p.show(false);
		p.show(true);
		
		Point p2 = new Point(50, 100);
		p2.show(true);
		p2.show(false);
		
		Point p3 = new ColorPoint();
		p3.setX(200);
		p3.setY(100);
		p3.show();
		
		Point p4=  new ColorPoint(10, 30, "blue");
		p4.show();
		p4.show(false);
		
		Shape s = new Rectangle(10, 20);
		draw(s);
		Shape c = new Circle(30);
		draw(c);
		
		//cast explicitly
		Rectangle r = (Rectangle)s;
		r.getHeight();
		//보통은 ((Rectangle)s).getHeight()); 이렇게 쓴다.
		
		Shape rec = new Rectangle(10,20);
		System.out.println(rec instanceof Drawable);
		System.out.println(rec instanceof Object);
		System.out.println(rec instanceof Shape);
		System.out.println(rec instanceof Rectangle);
		System.out.println(rec instanceof Circle);
		
		/**
		 * err
		 * instanceof 클래스의 경우 상속관계(부모 or 자식들만 연산할 수 있다. 
		 * Circle은 여기서 같은 레벨 형제?로 아예 관계 없는 클래스)
		 */
//		Rectangle rec = new Rectangle(10,20);
//		System.out.println(rec instanceof Drawable);
//		System.out.println(rec instanceof Object);
//		System.out.println(rec instanceof Shape);
//		System.out.println(rec instanceof Rectangle);
//		System.out.println(rec instanceof Circle);
	}
	
	//다형성을 이용한 메소드
	public static void draw(Shape s) {
		s.draw();
	}
}
