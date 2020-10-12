package study.fundamentals;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import edu.princeton.cs.algs4.StdOut;

public class Exercise_1_5_13 {
	
	private int count;
	private static int processedCount=0;
	


	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = null;
		try {
			String file = args[0];
			br = new BufferedReader(new FileReader(file));
			int N = Integer.valueOf(br.readLine()); // Read number of sites.
			
			Exercise_1_5_13 uf = new Exercise_1_5_13(N); // Initialize N components.
			String line = null;
			System.out.println(System.nanoTime());
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
			System.out.println(System.nanoTime());
//			uf.displayComponents();
		} finally {
			if(br != null)
				br.close();
		}
	}
	
	
	private int[] sites;
	public Exercise_1_5_13(int N) {
		this.count = N;
		sites = new int[N];
		for(int i=0;i<N;i++) {
			sites[i] = i;
		}
	}

	
	void union(int p, int q) {
		List<Integer> nodesOnPathToProot = this.collectNodesOnPathToRoot(p);
		List<Integer> nodesOnPathToQroot = this.collectNodesOnPathToRoot(q);
		List<Integer> allNodesOnPathToRoot = new ArrayList<>();
		allNodesOnPathToRoot.addAll(nodesOnPathToProot);
		allNodesOnPathToRoot.addAll(nodesOnPathToQroot);
		
		int rootOfP = this.findRoot(p);
		int rootOfQ = this.findRoot(q);
		
		int nodesOfPset = nodes(rootOfP);
		int nodesOfQset = nodes(rootOfQ);
		int root = -1;
		if(nodesOfPset < nodesOfQset) {
			this.sites[rootOfQ] = -1 * totalNodes(rootOfP, rootOfQ);
			this.sites[rootOfP] = rootOfQ;
			root = rootOfQ;
		}
		else {
			this.sites[rootOfP] = -1 * totalNodes(rootOfP, rootOfQ);
			this.sites[rootOfQ] = rootOfP;
			root = rootOfP;
		}
		
		for(Integer node: allNodesOnPathToRoot) {
			this.sites[node] = root;
		}
		
		this.count--;
		
		
		
	}




	
	
	private List<Integer> collectNodesOnPathToRoot(int p) {
		List<Integer> result = new ArrayList<>();
		while( !(this.sites[p] < 0 || this.sites[p] == p) ) {
			p = this.sites[p];
			result.add(p);
		}
		return result;
	}


	private int totalNodes(int rootOfQ, int rootOfP) {
		return this.nodes(rootOfP) + this.nodes(rootOfQ);
	}


	private int nodes(int rootOfP) {
		return this.sites[rootOfP] >= 0? 1 : Math.abs(this.sites[rootOfP]); 
	}


	public boolean connected(int p, int q) {
		
		return findRoot(p) == findRoot(q);
		
		
		
	}
	
	private int findRoot(int p) {
		
//		if(this.sites[p] == p || this.sites[p] < 0)
//			return p;
//		
//		return findRoot(this.sites[p]);
		while( !(this.sites[p] < 0 || this.sites[p] == p) ) {
			p = this.sites[p];
		}
		
		return p;
		
		
	}
	
//	private int findRoot(int p) {
//		
//		if(this.sites[p] == p || this.sites[p] < 0)
//			return p;
//		
//		return findRoot(this.sites[p]);
//		
//		
//	}


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
			System.out.println(i+": "+this.findRoot(i));
		}
		
	}

}
