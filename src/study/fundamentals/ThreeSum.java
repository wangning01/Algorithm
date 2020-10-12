package study.fundamentals;

import java.io.IOException;
import java.util.Arrays;

import edu.princeton.cs.algs4.BinarySearch;
import edu.princeton.cs.algs4.StdOut;

public class ThreeSum {
	
	public static void main(String args[]) throws NumberFormatException, IOException {
		
		int[] a = TwoSum.readFileIntoIntArray("C:\\Users\\wangn\\IdeaProjects\\Algorithm\\src\\study\\"
				+ "fundamentals\\1Kints.txt");
//		int[] a = TwoSum.readFileIntoIntArray("C:\\Users\\wangn\\IdeaProjects\\Algorithm\\src\\study\\"
//				+ "fundamentals\\test.txt");
		Arrays.sort(a);
		
		int count = 0;
		for(int i=0;i<a.length;i++) {
			for(int j=i+1;j<a.length;j++) {
				int index = BinarySearch.rank(-(a[i]+a[j]), a);
				if(index > j) {
//					StdOut.println("combo: "+a[i]+" "+a[j] +" "+a[index]);
					count++;
				}
					
			}
		}
		
		StdOut.println("3 SUM = "+count);
	}

}
