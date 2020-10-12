package study.algorithm;

import edu.princeton.cs.algs4.*;
import static edu.princeton.cs.algs4.StdDraw.*;


public class OneTwoThree {

    public static void main(String[] args){
        System.out.println("Please enter N:");
        int N = StdIn.readInt();
        int min = StdIn.readInt();
        int max = StdIn.readInt();

        int xScale = 100;
        int yScale = 100;
        setCanvasSize(500,500);
        setXscale(0,xScale);
        setYscale(0,yScale);

        Interval2D[] boxes = new Interval2D[N];

        for(int i=0;i<N;i++) {
            int xmin = StdRandom.uniform(min, max);
            int xmax = StdRandom.uniform(xmin, max);
            Interval1D xInterval = new Interval1D(xmin, xmax);

            int ymin = StdRandom.uniform(min,max);
            int ymax = StdRandom.uniform(ymin, max);
            Interval1D yInterval = new Interval1D(ymin, ymax);

            boxes[i] = new Interval2D(xInterval, yInterval);
            boxes[i].draw();
        }

    }
}
