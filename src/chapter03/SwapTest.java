package chapter03;

public class SwapTest {
	public static void main(String[] args) {
		int i = 0, j = 1;
		System.out.println("i : " + i + " j : " + j);
		swap(i,j);
		System.out.println("i : " + i + " j : " + j);
	}
	
	public static void swap(int i , int j) {
		int temp = i;
		i = j;
		j = temp;
	}
}
