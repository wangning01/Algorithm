package study.algorithm.chap2;

import org.apache.commons.lang3.ArrayUtils;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class MergeSortByTiger {
	
	private static int threshold = 10;
	
	public static void main(String[] args) {
		
		double[] array = readArrayFromStdInput();
		
		double[] sorted = MergeSortByTiger.sort(array);
		
		for(double ele: sorted) {
			StdOut.print(ele+", ");
		}
		
		
	}

	public static double[] sort(double[] array) {
		if(array.length < threshold) {
			ShellSort.sort(array);
			return array;
		}
		double[] firstHalf =  ArrayUtils.subarray(array, 0, array.length/2);
		double[] secondHalf = ArrayUtils.subarray(array, array.length/2, array.length); 
		
		double[] concatenated = ArrayUtils.addAll(sort(firstHalf), sort(secondHalf));
		
		mergeSort(concatenated, 0, concatenated.length/2-1, concatenated.length-1);
//		ShellSort.sort(concatenated);
		return concatenated;

		
	}


//	private static double[] subArray(double[] array, int start, int end) {
//		double[] result = new double[end-start];
//		for(int i=start,j=0;i<end;i++) {
//			result[j] = array[i];
//			j++;
//		}
//		return result;
//	}

	private static void mergeSort(double[] array, int low, int mid, int hi) {
		double[] aux = new double[array.length];
		for(int i=0;i<array.length;i++) {
			aux[i] = array[i];
		}
		
		int i=low;
		int j=mid+1;
		
		for(int k=low; k<=hi; k++) {
			if(i>mid)
				array[k] = aux[j++];
			else if(j>hi)
				array[k] = aux[i++];
			else if(less(aux[j], aux[i]))
				array[k] = aux[j++];
			else
				array[k] = aux[i++];
		}
		
	}

	private static boolean less(double d, double e) {
		return d<e ;
	}

	private static double[] readArrayFromStdInput() {
		String strArry = StdIn.readLine();
		double[] array = new double[strArry.split(",").length];
		String[] strArray = strArry.split(",");
		
		for(int i=0;i<strArray.length;i++) {
			array[i] = Double.valueOf(strArray[i]);
		}
		return array;
	}

}
