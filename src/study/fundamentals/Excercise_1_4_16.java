package study.fundamentals;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Excercise_1_4_16 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		double a[] = readFileIntoDoubleArray("C:\\Users\\wangn\\IdeaProjects\\Algorithm\\src\\study\\"
				+ "fundamentals\\1Kints.txt");
		
		Arrays.sort(a);
		
		System.out.println(findClosestPair(a));
		
	}
	
	private static String findClosestPair(double[] a) {
		
		double smallestDiff = Double.POSITIVE_INFINITY;
		int p1 = 0;
		int p2 = 0;
		for(int i=0;i<a.length-1;i++) {
			System.out.println(a[i]);
			if(Math.abs(a[i]-a[i+1]) < smallestDiff) {
				smallestDiff = Math.abs(a[i]-a[i+1]);
				p1 = i;
				p2 = i+1;
			}
		}
		
		return "closest pair: "+a[p1]+", "+a[p2];
		
	}

	public static double[] readFileIntoDoubleArray(String inputFile) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new FileReader(inputFile));
		List<Double> list = new ArrayList<>();
		String line = null;
		while((line = br.readLine()) != null) {
			list.add(Double.valueOf(line.trim()));
		}
		double[] array = list.stream().mapToDouble(i -> i).toArray();
		return array;
	
	}
}
