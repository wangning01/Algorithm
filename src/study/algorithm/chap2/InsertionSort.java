package study.algorithm.chap2;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class InsertionSort {
	
	public static void main(String[] args) {
		String strArry = StdIn.readLine();
		double[] array = new double[strArry.split(",").length];
		String[] strArray = strArry.split(",");
		
		for(int i=0;i<strArray.length;i++) {
			array[i] = Double.valueOf(strArray[i]);
		}
		
		
//		InsertionSort insertionSort = new InsertionSort();
//		InsertionSort.sortByBinarySearch(array);
		InsertionSort.sort(array);
		
		for(double ele: array) {
			StdOut.print(ele+", ");
		}
	}

	public static void sortByBinarySearch(double[] array) {
		
		for(int i=1;i<array.length;i++) {
			int insertionPosition = findInsertionPosition(array, i);

			
			double tmp = array[i];
			// Shift all elements 
			// between the found insertionPosition and position (i-1) by 1 to right 
			shift(array, insertionPosition, i-1);
			array[insertionPosition] = tmp;
		}
	}
	
	public static void sort(double[] array) {
		for(int i=0;i<array.length;i++) {
			int j=i;
			while(j>0 && less(array[j], array[j-1])) {
				exchange(j, j-1, array);
				j=j-1;
			}
		}
	}


	private static void exchange(int j, int i, double[] array) {
		double tmp = array[j];
		array[j] = array[i];
		array[i] = tmp;
	}

	private static boolean less(double d, double e) {
		return (d-e)<=0;
	}

	private static void shift(double[] array, int startIndex, int endIndex) {
		for(int i=endIndex;i>=startIndex;i--) {
			array[i+1] = array[i];
		}
	}

	private static int findInsertionPosition(double[] array, int searchIndex) {
		
		double searchValue = array[searchIndex];
//		for(int i=0;i<=sortedUptoIndex;i++) {
//			if()
//		}
		int low = 0;
		int high = searchIndex - 1;
		int middle = (high-low)/2 + low;
		while(array[middle] != searchValue) {
			if(array[middle] < searchValue) {
				low = middle +1;
			}else {
				high = middle -1;
			}
			
			if(low <= high)
				middle = (high-low)/2 + low;
			else
				return low;
		}
		
		return middle;
		
	}

}
