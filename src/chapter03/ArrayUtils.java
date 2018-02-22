package chapter03;

public class ArrayUtils {
	/**
	 * int 배열을 double 배열로 변환
	 */
	public static double [] intToDouble(int [] source) {
		if(source == null)
			return null;
		double [] output = new double[source.length];
		for(int i = 0; i < output.length; i++)
			output[i] = (double)source[i];
		return output;
	}
	
	/**
	 * double 배열을 int 배열로 변환
	 */
	public static int [] doubleToInt(double [] source) {
		if(source == null)
			return null;
		int [] output = new int[source.length];
		for(int i = 0; i < output.length; i++)
			output[i] = (int)source[i];
		return output;
	}
	
	/**
	 * int 배열 두 개를 연결한 새로운 배열 리턴
	 */
	public static int [] concat(int [] s1, int [] s2) {
		if(s1 == null || s2 == null)
			return null;
		int [] output = new int[s1.length + s2.length];
		for(int i = 0; i < output.length; i++)
			output[i] = i < s1.length ? s1[i] : s2[i - s1.length];
		return output;
	}
}
