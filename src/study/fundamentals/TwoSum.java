package study.fundamentals;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import study.algorithm.BinarySearch;

public class TwoSum {
	
	public static void main(String[] args) throws IOException {
//		int N = 50;
//		int[] a = new int[N];
//		
//		for(int i=0;i<N;i++) {
//			a[i] = StdRandom.uniform(-50, 50);
//		}
//		
//		Arrays.sort(a);
		
		
		
		
		int[] a = readFileIntoIntArray("C:\\Users\\wangn\\IdeaProjects\\Algorithm\\src\\study\\"
						+ "fundamentals\\test.txt");
		Arrays.sort(a);
		int cnt = 0;
		int j = 0;
		List<Integer> result = new ArrayList<Integer>();
		for(int i=0;i<a.length;i++) {
			StdOut.println(a[i]);
			if((j=BinarySearch.rank(-a[i], a)) >-1 && j>i) {
				result.add(a[i]);
				cnt++;
			}
				
		}
		
		StdOut.println("2-Sum result = "+cnt);
		for(Integer e: result) {
//			StdOut.println(e);
		}
		
		
		
		
//		StdOut.println("Unique: " + checkUnique
//				("C:\\Users\\wangn\\IdeaProjects\\Algorithm\\src\\study\\"
//						+ "fundamentals\\8Kints.txt"));
		
	}
	
	public static int[] readFileIntoIntArray(String inputFile) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new FileReader(inputFile));
		List<Integer> list = new ArrayList<Integer>();
		String line = null;
		while((line = br.readLine()) != null) {
			list.add(Integer.valueOf(line.trim()));
		}
		int[] array = list.stream().mapToInt(i -> i).toArray();
		return array;
	
	}

	public static boolean checkUnique(String inputFile) throws IOException {
		int[] array = readFileIntoIntArray(inputFile);
		Arrays.sort(array);
		
//		for(int ele: array) {
//			StdOut.println(ele);
//		}
		for(int i=0;i<array.length;i++) {
			if(i-1 >-1) {
				if(array[i] == array[i-1])
					return false;
			}else
				continue;
		}
		
		return true;
	}

}
