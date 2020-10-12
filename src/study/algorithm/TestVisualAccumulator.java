package study.algorithm;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class TestVisualAccumulator {
    public static void main(String[] args)
    {
        //int T = Integer.parseInt(args[0]);
        int T = 1000;
        VisualAccumulator a = new VisualAccumulator(T, 1.0);
        for (int t = 0; t < T; t++)
            a.addDataValue(StdRandom.random());
        StdOut.println(a);
    }
}
