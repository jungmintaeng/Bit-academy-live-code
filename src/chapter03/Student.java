package chapter03;

public class Student extends Person{
	private String grade;
	private String major;
	
	public Student() {
		System.out.println("자식 생성자 호출 Student()");
	}
	
	public Student(int age) {
		super(age);
		System.out.println("자식 생성자 호출 Student(int)");
	}
	
	public void set() {
		//public
		name = "둘리";
		
		//protected
		height = 150;
		
		//default
		age = 37;
		
		//private
//		weight = 1;
	}
}
