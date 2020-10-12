package study.fundamentals;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Excercise_1_5_3 {
	private int[] id; // parent link (site indexed)
	private int[] sz; // size of component for roots (site indexed)
	private int count; // number of components
	private int arrayAccess = 0;

	public void setArrayAccess(int arrayAccess) {
		this.arrayAccess = arrayAccess;
	}

	public Excercise_1_5_3(int N)
	{
		count = N;
		id = new int[N];
		for (int i = 0; i < N; i++)
			id[i] = i;
		sz = new int[N];
		for (int i = 0; i < N; i++)
			sz[i] = 1;
	}

	public int count() {
		return count;
	}

	public boolean connected(int p, int q) {
		return find(p) == find(q);
	}

	private int find(int p) { // Follow links to find a root.
		while (p != id[p]) {
			p = id[p];
			this.arrayAccess++;
		}
		this.arrayAccess++;
		return p;
	}

	public void union(int p, int q) {
		int i = find(p);
		int j = find(q);
		if (i == j)
			return;
		// Make smaller root point to larger one.
		if (sz[i] < sz[j]) {
			id[i] = j;
			sz[j] += sz[i];
		} else {
			id[j] = i;
			sz[i] += sz[j];
		}
		this.arrayAccess++;
		count--;
	}

	// See page 222 (quick-find),page 224 (quick-union) andpage 228 (weighted).
	public static void main(String[] args) { // Solve dynamic connectivity problem on StdIn.
		int N = StdIn.readInt(); // Read number of sites.
		Excercise_1_5_3 uf = new Excercise_1_5_3(N); // Initialize N components.
		while (!StdIn.isEmpty()) {
			int p = StdIn.readInt();
			int q = StdIn.readInt(); // Read pair to connect.
			if (uf.connected(p, q)) {
				uf.print(p, q);
				uf.setArrayAccess(0);
				continue; // Ignore if connected.
			}
			uf.union(p, q); // Combine components
			uf.print(p, q);
			uf.setArrayAccess(0);
			StdOut.println(p + " " + q); // and print connection.
		}
		StdOut.println(uf.count() + " components");
	}

	private void print(int p, int q) {
		for (int i = 0; i < id.length; i++) {
			System.out.print("[" + i + "]:" + id[i] + ",");
		}
		System.out.println("Total array access for pairs: " + p + "," + q + "=" + this.arrayAccess);
	}
}
