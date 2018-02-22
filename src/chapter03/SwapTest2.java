package chapter03;

public class SwapTest2 {
	public static void main(String[] args) {
		Value v1 = new Value();
		Value v2 = new Value();
		v1.setValue(10);
		v2.setValue(20);
		System.out.println("v1 : " + v1.getValue() + " v2 : " + v2.getValue());
		swap(v1,v2);
		System.out.println("v1 : " + v1.getValue() + " v2 : " + v2.getValue());
	}
	
	public static void swap(Value i , Value j) {
		int temp = i.getValue();
		i.setValue(j.getValue());
		j.setValue(temp);
	}
}
