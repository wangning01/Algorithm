package study.fundamentals;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoSumFaster {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		int[] a = readFileIntoIntArray("C:\\Users\\wangn\\IdeaProjects\\Algorithm\\src\\study\\"
				+ "fundamentals\\test.txt");
		
		Arrays.sort(a);
		
		
		System.out.println("Total count: " + findCount(0, a) );
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

	public static int findCount(int key, int[] a) {
		
		return findCount(key, a, 0);
	}

	private static int[] fromArray(int[] original, int offset) {
		int[] copy = new int[original.length-offset];
		int j=0;
		for(int i=offset;i<original.length;i++) {
			copy[j] = original[i];
			j++;
		}
		
		return copy;
	}

	public static int findCount(int key, int[] a, int offset) {
		int[] copy = fromArray(a, offset);
		
		Arrays.sort(copy);
		
		int i=0;
		int j=copy.length-1;
		int count = 0;
		
		while(i<j) {
			if(copy[i] + copy[j] == key) {
				count++;
				i++;
				j--;
			}
			else if(copy[i] + copy[j] > key)
				j--;
			else
				i++;
		}
		
		return count;
	}
}
