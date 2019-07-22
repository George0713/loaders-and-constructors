package questions;

import java.util.Arrays;
import java.util.function.IntPredicate;

public class Test2{
	public static void main(String[] args) {
		System.out.println("A test");
		System.out.println(7 - 2 + Math.log10(1000) + Math.log(Math.pow(Math.E, 5)));
		System.out.println("Grandalf the GRAY".replace("a", "oo"));
		
		int[] array=new int[4];
		System.out.println(12%8);
		
		int[] a = {2,4,6,8,10,12,14,16};
		int[] b = {1,1,2,3,5,8,13,21};
		
		s(a,b);
		System.out.println(Arrays.toString(a));
	}
	
	public static void s(int[] a,int[] b) {
		
		for(int i=0;i<a.length;i++) {
			System.out.println( a[i*2%a.length] +" "+b[i*3%b.length]);
			a[i] = a[i*2%a.length]-b[i*3%b.length];
		}
		
	}
}