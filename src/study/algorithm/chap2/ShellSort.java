package study.algorithm.chap2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class ShellSort {
	
	private static int  numberOfCompares = 0;
	
//	public static void main(String[] args) {
//		
//		String strArry = StdIn.readLine();
//		double[] array = new double[strArry.split(",").length];
//		String[] strArray = strArry.split(",");
//		
//		for(int i=0;i<strArray.length;i++) {
//			array[i] = Double.valueOf(strArray[i]);
//		}
//		
////		ShellSort.sort(array);
//		ShellSort.sort_2_1_11_exercise(array);
//		
//		for(double ele: array) {
//			StdOut.print(ele+", ");
//		}
//	}
	
	public static void main(String[] args) {
		int n = 100;
		System.out.println("n="+n);
		System.out.println(numberOfComapres_exercise_2_1_12(n) / n);
		
		n=1000;
		System.out.println("n="+n);
		System.out.println(numberOfComapres_exercise_2_1_12(n) / n);
		
		n=10000;
		System.out.println("n="+n);
		System.out.println(numberOfComapres_exercise_2_1_12(n) / n);
		
		n=100000;
		System.out.println("n="+n);
		System.out.println(numberOfComapres_exercise_2_1_12(n) / n);
		
		n=1000000;
		System.out.println("n="+n);
		System.out.println(numberOfComapres_exercise_2_1_12(n) / n);
	}

	public static void sort_tiger_own(double[] array) {
		int h=1;
		while(h<array.length/3) h = 3*h +1; 
		while(h>=1) {
			for(int i=0;i<h;i++) {
				for(int j=i;j<array.length;j+=h) {
					int k=j;
					while(k>i && less(array[k], array[k-h])) {
						exchange(k, k-h, array);
						k=k-h;
					}
				}
			}
			h=h/3;
		}
	}
	
	public static void sort_2_1_11_exercise(double[] a) { // Sort a[] into increasing order.
		List<Integer> increments = new ArrayList<>();
		int N = a.length;
		int h = 1;
		increments.add(h);
		while (h < N / 3) {
			h = 3 * h + 1; // 1, 4, 13, 40, 121, 364, 1093, ...
			increments.add(h);
		}
		
		Collections.reverse(increments);
		
		for(int increment: increments) {
			for (int i = increment; i < N; i++) { // Insert a[i] among a[i-h], a[i-2*h], a[i-3*h]... .
				for (int j = i; j >= increment && less(a[j], a[j - increment]); j -= increment)
					exchange(j, j - increment, a);
			}
		}
		
		
//		while (h >= 1) { // h-sort the array.
//			for (int i = h; i < N; i++) { // Insert a[i] among a[i-h], a[i-2*h], a[i-3*h]... .
//				for (int j = i; j >= h && less(a[j], a[j - h]); j -= h)
//					exchange(j, j - h, a);
//			}
//			h = h / 3;
//		}
	}
	
	public static void sort(double[] a) {
		int N = a.length;
		int h = 1;
		while (h < N / 3) {
			h = 3 * h + 1; // 1, 4, 13, 40, 121, 364, 1093, ...
		}
		
		while (h >= 1) { // h-sort the array.
			for (int i = h; i < N; i++) { // Insert a[i] among a[i-h], a[i-2*h], a[i-3*h]... .
				for (int j = i; j >= h && less(a[j], a[j - h]); j -= h)
					exchange(j, j - h, a);
			}
			h = h / 3;
		}
	}
	

	private static void exchange(int k, int i, double[] array) {
		double tmp = array[k];
		array[k] = array[i];
		array[i] = tmp;
	}

	private static boolean less(double d, double e) {
		numberOfCompares++;
		return (d-e)<0;
	}
	
	
	private static int numberOfComapres_exercise_2_1_12(int arrSize) {
		double[] array = new double[arrSize];
		for(int i=0;i<arrSize;i++) {
			array[i] = StdRandom.uniform(0, 1000000d);
		}
		sort(array);
		int result = numberOfCompares;
		numberOfCompares = 0;
		return result;
		
		
		
	}
	

}
