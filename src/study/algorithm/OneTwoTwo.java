package study.algorithm;

import edu.princeton.cs.algs4.Interval1D;
import edu.princeton.cs.algs4.StdIn;

public class OneTwoTwo {

    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println("Please enter an Integer N as argument...");
            System.exit(1);
        }

        String strN = args[0];
        Integer N = Integer.valueOf(strN);

        Interval1D[] intervals = new Interval1D[N];

        System.out.println("Please enter N pairs of end points:");

        for (int i = 0; i < N; i++) {
            System.out.println("Please enter Pair " + i);

            double p1 = StdIn.readDouble();
            double p2 = StdIn.readDouble();

            Interval1D interval = new Interval1D(p1, p2);
            intervals[i] = interval;
        }
        System.out.println("Thanks for entering " + N + " pairs of points.");
        int count = 0;
        for (int i = 0; i < intervals.length; i++) {
            for (int j = i + 1; j < intervals.length; j++) {
                if (intervals[i].intersects(intervals[j])) {
                    System.out.println("Interval " + i + " And Interval " + j + " intersects.");
                    count++;
                }
            }
        }
        System.out.println("There are total of " + count + " pairs intersect...");
    }
}
