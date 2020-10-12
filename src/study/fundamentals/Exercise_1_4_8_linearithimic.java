package study.fundamentals;

import java.util.Arrays;

import edu.princeton.cs.algs4.StdRandom;

public class Exercise_1_4_8_linearithimic {
	
	public static void main(String[] args) {
		/**
		 * Generate random numbers and write them to an array
		 */
		int N = 500;
		int[] array = new int[N];
		for(int i=0;i<N;i++) {
			array[i] = StdRandom.uniform(0, 10000);
		}
		
		int count=0;
		for(int i=0;i<N;i++) {
//			System.out.println(array[i]);
			for(int j=i+1;j<N;j++) {
				if(array[i] == array[j]) {
//					System.out.println("equal value: " + array[i]);
					count++;
				}
					
			}
		}
		
		System.out.println("Total equal pairs:"+count);
		
		count=0;
		Arrays.sort(array);
		for(int i=0;i<N;i++) {
			count+= findEqualCount(i, array);
		}
		
		System.out.println("Total "+count);
		
	}

	private static int findEqualCount(int index, int[] a) {
		
		int key = a[index];
		
		int lo = 0;
        int hi = a.length - 1;
        int highestIndex = -1;
        while (lo <= hi) { // Key is in a[lo..hi] or not present.
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid])
                hi = mid - 1;
            else if (key > a[mid])
                lo = mid + 1;
            else {
            	highestIndex = mid;
                break;
            }
        }
        
        if(highestIndex > -1) {
        	for(int i=highestIndex;i<a.length-1 && a[i]==a[i+1];i++) {
        		highestIndex++;
        	}
        	
        	return highestIndex - index;
        }else
        	return 0;
        
        
		
	}
	
	public static int rank(int key, int[] a) { // Array must be sorted.
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) { // Key is in a[lo..hi] or not present.
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid])
                hi = mid - 1;
            else if (key > a[mid])
                lo = mid + 1;
            else
                return mid;
        }
        return -1;
    }

}
