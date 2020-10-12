package study.algorithm.chap2;

import java.util.Map;
import java.util.TreeMap;

import edu.princeton.cs.algs4.StdIn;

public class MergeSort {
	
	private static double[] aux;
	private static int depth=-1;
	private static int height=0;
	private static Map<Integer, Boolean> levelReadMap = new TreeMap<>();
	
	
	public static void main(String[] args) {
		double[] array = readArrayFromStdInput();
		init(array);
		
		sort(array, 0, array.length-1);
		
		if(levelReadMap.get(height)) 
			array = aux;
			
		
		for(double e: array) {
			System.out.print(e+", ");
		}
//		System.out.println();
//		for(double e: aux) {
//			System.out.print(e+", ");
//		}
		
	}
	
	
	private static void init(double[] array) {
		aux = array.clone();
		height = (int) Math.ceil((Math.log(array.length) / Math.log(2))) +1;
		
		boolean read = false;
		for(int i=1;i<=height;i++) {
			levelReadMap.put(i, read);
			read = !read;
		}
		
	}
	
	

	private static void sort(double[] array, int low, int high) {
		depth++;
		if(low >= high) {
			depth--;
			return;
		}
		int mid = low + (high-low)/2;
		sort(array, low, mid);
		sort(array, mid+1, high);
//		read = !read;
		merge(array, low, mid, high);
		depth--;
		
	}


	private static void merge(double[] array, int low, int mid, int high) {
//		for(int i=low;i<=high;i++) {
//			aux[i] = array[i];
//		}
		
		boolean read = levelReadMap.get(height-depth);
		
		double[] source = null;
		double[] target = null;
		
		if(read) {
			source = array;
			target = aux;
		}else {
			source = aux;
			target = array;
		}
		
		
		int i=low;
		int j=mid+1;
		
		for(int k=low;k<=high;k++) {
			if(i>mid) 
				target[k] = source[j++];
			else if(j>high) 
				target[k] = source[i++];
			else if(source[i] <= source[j]) 
				target[k] = source[i++];
			else 
				target[k] = source[j++];
			
		}
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
