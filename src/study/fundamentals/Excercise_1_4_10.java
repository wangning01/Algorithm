package study.fundamentals;

import java.util.Arrays;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Excercise_1_4_10 {

	public static int rank(int key, int[] a) { // Array must be sorted.
        int lo = 0;
        int hi = a.length - 1;
        int result = -1;
        while (lo <= hi) { // Key is in a[lo..hi] or not present.
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid])
                hi = mid - 1;
            else if (key > a[mid])
                lo = mid + 1;
            else {
            	result = mid;
            	hi = mid -1;
//                return mid;
            }
            	
        }
        return result;
    }

    public static void main(String[] args) {
    	int N = 500;
		int[] array = new int[N];
		for(int i=0;i<N;i++) {
			array[i] = StdRandom.uniform(0, 10000);
		}
        Arrays.sort(array);
        for(int i=0;i<N;i++) {
        	System.out.println(array[i]);
		}
        
        
        int smallestIndex = -1;
        while (!StdIn.isEmpty()) { // Read key, print if not in whitelist.
            int key = StdIn.readInt();
            if ((smallestIndex=rank(key, array)) < 0)
                StdOut.println("Not found "+key);
            else
            	StdOut.println("Found "+key + " and smallest index="+smallestIndex);
        }
    }
}
