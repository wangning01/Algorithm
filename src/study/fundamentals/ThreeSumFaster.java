package study.fundamentals;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSumFaster {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		int[] a = readFileIntoIntArray("C:\\Users\\wangn\\IdeaProjects\\Algorithm\\src\\study\\"
				+ "fundamentals\\test.txt");
		
		Arrays.sort(a);
		
		System.out.println("Total 3-sum count is: " + findCount(0, a));
		
	}
	
	private static int findCount(int key, int[] a) {
		
		int count = 0;
		
		for(int i=0;i<a.length-2;i++) {
			count = count + TwoSumFaster.findCount(-a[i], a, i+1);
		}
		
		return count;
		
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
