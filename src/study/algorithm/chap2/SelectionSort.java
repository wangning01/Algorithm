package study.algorithm.chap2;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class SelectionSort {
	
	public static void main(String[] args) {
		String strArry = StdIn.readLine();
		double[] array = new double[strArry.split(",").length];
		String[] strArray = strArry.split(",");
		
		for(int i=0;i<strArray.length;i++) {
			array[i] = Integer.valueOf(strArray[i]);
		}
		
		
//		SelectionSort selectSort = new SelectionSort();
		SelectionSort.sort(array);
		
		for(double ele: array) {
			StdOut.print(ele+",");
		}
	}

	public static void sort(double[] array) {
		
		for(int i=0;i<array.length;i++) {
			int smallestIndex = indexOfSmallestItemInArray(i,array);
			if(smallestIndex !=i ) {
				exchange(array, i, smallestIndex);
			}
		}
		
	}

	private static void exchange(double[] array, int idx1, int idx2) {
		double tmp = -1;
		tmp = array[idx1];
		array[idx1] = array[idx2];
		array[idx2] = tmp;
	}

	private static int indexOfSmallestItemInArray(int start, double[] array) {
		int smallestIndex = start;
		for(int i=start;i<array.length;i++) {
			if(array[i] < array[smallestIndex])
				smallestIndex = i;
		}
		
		return smallestIndex;
	}
	
}
