package study.fundamentals;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import edu.princeton.cs.algs4.StdOut;

public class UFquickFind {
	
//	public static void main(String[] args) {
//		System.out.println("Please enter number of sites:");
//		int N = StdIn.readInt(); // Read number of sites.
//		UF uf = new UF(N); // Initialize N components.
//		String line = null;
//		while( (line = StdIn.readLine())!=null 
//				&&  ! (line.trim().equals("xx")) )
//		{
//			if(StringUtils.isEmpty(line))
//				continue;
//				
//			String[] arry = line.split(" ");
//			int p = Integer.valueOf(arry[0].trim());
//			int q = Integer.valueOf(arry[1].trim());
//			if (uf.connected(p, q)) {
//				System.out.println("Already connected.");
//				continue;
//			} // Ignore if connected.
//			uf.union(p, q); // Combine components
//			StdOut.println(p + " " + q); // and print connection.
//		}
//		StdOut.println(uf.count() + " components");
//		uf.displayComponents();
//	}
	private int count;
	private static int processedCount=0;
	


	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = null;
		try {
			String file = args[0];
			br = new BufferedReader(new FileReader(file));
			int N = Integer.valueOf(br.readLine()); // Read number of sites.
			
			UFquickFind uf = new UFquickFind(N); // Initialize N components.
			String line = null;
			System.out.println(new Date());
			while ((line = br.readLine()) != null) {
				processedCount++;
				if(processedCount%100000 == 0)
					StdOut.println(processedCount + " lines processed.");
				if (StringUtils.isEmpty(line))
					continue;

				String[] arry = line.split(" ");
				int p = Integer.valueOf(arry[0].trim());
				int q = Integer.valueOf(arry[1].trim());
				if (uf.connected(p, q)) {
//					System.out.println(p + " " + q +" Already connected.");
					continue;
				} // Ignore if connected.
				uf.union(p, q); // Combine components
//				StdOut.println(p + " " + q); // and print connection.
			}
			StdOut.println(uf.count() + " components");
			System.out.println(new Date());
//			uf.displayComponents();
		} finally {
			if(br != null)
				br.close();
		}
	}
	
	
	private int[] sites;
	public UFquickFind(int N) {
		this.count = N;
		sites = new int[N];
		for(int i=0;i<N;i++) {
			sites[i] = i;
		}
	}

	
	void union(int p, int q) {
		assert(p>-1 && p<this.sites.length 
				&& q>-1 && q<this.sites.length 
				&& p!=q);
		
		if(this.findComponentIdOfSite(p) == this.findComponentIdOfSite(q)) {
			//System.out.println(p + " and " +q + " already connected.");
			return;
		}
		
//		copyValuesFromTo(this.sites[p], this.sites[q]);
		
		int countOfPcomponent = findCountOfComponent(this.sites[p]);
		int countOfQcomponent = findCountOfComponent(this.sites[q]);
		
		if(countOfPcomponent == countOfQcomponent) {
			if(this.sites[p] < this.sites[q])
				copyValuesFromTo(this.sites[p], this.sites[q]);
			else
				copyValuesFromTo(this.sites[q], this.sites[p]);
		}else if(countOfPcomponent < countOfQcomponent){
			copyValuesFromTo(this.sites[q], this.sites[p]);
		}else {
			copyValuesFromTo(this.sites[p], this.sites[q]);
		}
		
		count--;
			
		
//		this.components[p] = this.components[q] = smaller(components[p], components[q]);
			
	}


	private void copyValuesFromTo(int sourceComponentId, int targetComponentId) {
		for(int i=0;i<this.sites.length;i++) {
			if(this.sites[i] == targetComponentId) {
				this.sites[i] = sourceComponentId;
			}
		}
	}


	private int findCountOfComponent(int componentId) {
		int count = 0;
		for(int id: this.sites) {
			if(id == componentId)
				count++;
		}
		
		return count;
	}


	
	public int findComponentIdOfSite(int p) {
		return this.sites[p];
	}
	
	public boolean connected(int p, int q) {
		return findComponentIdOfSite(p) == findComponentIdOfSite(q);
	}
	
	public int count() {
//		Set<Integer> distinctSet = new HashSet<>();
//		
//		for(int i=0;i<this.sites.length;i++) {
//			distinctSet.add(this.sites[i]);
//		}
//		
//		return distinctSet.size();
		return this.count;
	}
	
	private  void displayComponents() {
		for(int i=0;i<this.sites.length;i++) {
			System.out.println(i+": "+this.findComponentIdOfSite(i));
		}
		
	}

}
