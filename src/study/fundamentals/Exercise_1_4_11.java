package study.fundamentals;

import java.util.Arrays;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Exercise_1_4_11 {
	public static void main(String[] args) {
		int[] w = getSortedWhiteList();
		
		for(int i=0;i<w.length;i++) {
			StdOut.println(w[i]);
		}
		
		StaticSETofInts set = new StaticSETofInts(w);
		while (!StdIn.isEmpty()) { // Read key, print if not in whitelist.
			int key = StdIn.readInt();
			if (set.rank(key) == -1)
				StdOut.println("Not found " + key);
			else {
				StdOut.println("Found "+key);
				StdOut.println("Smallest index: "+set.findSmallestIndex(key));
				StdOut.println("largest index: "+set.findLargestIndex(key));
				StdOut.println(set.howMany(key));
			}
		}
	}

	private static int[] getSortedWhiteList() {
		int N = 500;
		int[] array = new int[N];
		for(int i=0;i<N;i++) {
			array[i] = StdRandom.uniform(0, 10000);
		}
        Arrays.sort(array);
        return array;
	}
	
	
}
