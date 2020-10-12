package study.algorithm.chap2;

import java.util.Map;
import java.util.TreeMap;

import edu.princeton.cs.algs4.StdRandom;

public class Excercise_2_1_12 {

	private Map<Integer, Integer> incrementArraySizeMap = new TreeMap<>();
	private double[] array;
	
	public Excercise_2_1_12(double[] array) {
		this.array = array;
	}

	public Map<Integer, Integer> getIncrementArraySizeMap() {
		return incrementArraySizeMap;
	}

	public  void sort(double[] a) {
		int numOfCompares = 0;
		int N = a.length;
		int h = 1;
		while (h < N / 3) {
			h = 3 * h + 1; // 1, 4, 13, 40, 121, 364, 1093, ...
		}
		
		while (h >= 1) { // h-sort the array.
			for (int i = h; i < N; i++) { // Insert a[i] among a[i-h], a[i-2*h], a[i-3*h]... .
				for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
					numOfCompares++;
					exchange(j, j - h, a);
				}
			}
			numOfCompares++;
			incrementArraySizeMap.put(numOfCompares, a.length);
			numOfCompares = 0;
			h = h / 3;
		}
	}
	
	private  void exchange(int k, int i, double[] array) {
		double tmp = array[k];
		array[k] = array[i];
		array[i] = tmp;
	}
	
	private  boolean less(double d, double e) {
		return (d-e)<0;
	}
	

	private static double[] getRandomArray(int arrSize) {
		double[] array = new double[arrSize];
		for(int i=0;i<arrSize;i++) {
			array[i] = StdRandom.uniform(0, 1000000d);
		}
		
		return array;
	}
	
	public static void main(String[] args) {
		printNumOfCompareToArrSizeMap(100);
		printNumOfCompareToArrSizeMap(1000);
		printNumOfCompareToArrSizeMap(10000);
		printNumOfCompareToArrSizeMap(100000);
		
	}c

	private static void printNumOfCompareToArrSizeMap(int arrSize) {
		System.out.println("n="+arrSize);
		double[] array = getRandomArray(arrSize);
		Excercise_2_1_12 a = new Excercise_2_1_12(array);
		a.sort(array);
		System.out.println(a.getIncrementArraySizeMap());
		
	}
}
