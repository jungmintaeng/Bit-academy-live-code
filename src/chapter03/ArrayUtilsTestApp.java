package chapter03;

public class ArrayUtilsTestApp {
	public static void main(String[] args) {
		int [] intArray = {1,2,3,4,5};
		double [] doubleArray = ArrayUtils.intToDouble(intArray);
		
		printArray(doubleArray);
		
		for(int i = 0 ; i < doubleArray.length; i++) {
			doubleArray[i] = 1.1 * i;
		}
		
		printArray(doubleArray);
		intArray = ArrayUtils.doubleToInt(doubleArray);
		
		printArray(intArray);
		printArray(ArrayUtils.concat(intArray, ArrayUtils.doubleToInt(doubleArray)));
	}
	
	public static void printArray(int [] arr) {
		if(arr == null)
			return;
		for(int i = 0 ; i < arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}
	
	public static void printArray(double [] arr) {
		if(arr == null)
			return;
		for(int i = 0 ; i < arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}
}
