package study.fundamentals;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import edu.princeton.cs.algs4.StdRandom;

public class Exercise_1_4_8_quadratic {
	
	public static void main(String[] args) throws IOException {
		/**
		 * Generate 1000 random numbers and write them to a file
		 */
//		int N = 1000;
//		String outputFile = "c:/study/1_4_8.txt";
//		PrintWriter pw = new PrintWriter(new File(outputFile));
//		for(int i=0;i<N;i++) {
//			if(i<N-1)
//				pw.println(StdRandom.uniform(0, 10000));
//			else
//				pw.print(StdRandom.uniform(0, 10000));
//		}
//		pw.close();
		
		/**
		 * Generate random numbers and write them to an array
		 */
		int N = 10000;
		int[] array = new int[N];
		for(int i=0;i<N;i++) {
			array[i] = StdRandom.uniform(0, 10000);
		}
		
		
		int count=0;
		for(int i=0;i<N;i++) {
			System.out.println(array[i]);
			for(int j=i+1;j<N;j++) {
				if(array[i] == array[j]) {
					System.out.println("equal value: " + array[i]);
					count++;
				}
					
			}
		}
		
		System.out.println("Total "+count);
	}

}
