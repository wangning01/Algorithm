package study.fundamentals;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Excercise_1_5_1 {
	private int[] id; // access to component id (site indexed)
	private int count; // number of components

	public Excercise_1_5_1(int N) { // Initialize component id array.
		count = N;
		id = new int[N];
		for (int i = 0; i < N; i++)
			id[i] = i;
	}

	public int count() {
		return count;
	}

	public boolean connected(int p, int q) {
		return find(p) == find(q);
	}

	public int find(int p) {
		return id[p];
	}

	public void union(int p, int q) {
		int arrayAccess = 0;
		int pID = find(p);
		arrayAccess++;
		int qID = find(q);
		arrayAccess++;
		// Nothing to do if p and q are already in the same component.
		if (pID == qID) return;
		// Rename p�s component to q�s name.
		for (int i = 0; i < id.length; i++) {
			if (id[i] == pID) {
				id[i] = qID;
				arrayAccess++;
			}
			arrayAccess++;
		}
		count--;
		
		for(int i=0;i<id.length;i++) {
			System.out.print("["+i+"]:"+id[i]+",");
		}
		System.out.println("Total array access for pairs: "+p+","+q+"="+arrayAccess);
	}
	// See page 222 (quick-find),page 224 (quick-union) andpage 228 (weighted).
	public static void main(String[] args) { // Solve dynamic connectivity problem on StdIn.
		int N = StdIn.readInt(); // Read number of sites.
		Excercise_1_5_1 uf = new Excercise_1_5_1(N); // Initialize N components.
		while (!StdIn.isEmpty()) {
			int p = StdIn.readInt();
			int q = StdIn.readInt(); // Read pair to connect.
			if (uf.connected(p, q))
				continue; // Ignore if connected.
			uf.union(p, q); // Combine components
			StdOut.println(p + " " + q); // and print connection.
		}
		StdOut.println(uf.count() + " components");
	}
}
