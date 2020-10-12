package study.algorithm;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;


import static edu.princeton.cs.algs4.StdDraw.*;

public class OneTwoOne {

    public static void main(String[] args){

        int N =  Integer.parseInt(args[0]);

        setCanvasSize(500,500);
        setXscale(0,100);
        setYscale(0,100);
        setPenRadius(0.005);
        setPenColor(RED);
        enableDoubleBuffering();

        Point2D[] points = new Point2D[N];
        for(int i=0;i<N;i++){
            int x = StdRandom.uniform(100);
            int y = StdRandom.uniform(100);
            points[i] = new Point2D(x, y);
            points[i].draw();
            show();
        }

        double minDistance=200;
        Point2D a = null;
        Point2D b = null;

        for(int i=0;i<N;i++){
            for(int j=i+1;j<N;j++){
                double distance = points[i].distanceTo(points[j]);
                if(distance<minDistance) {
                    minDistance = distance;
                    a = points[i];
                    b = points[j];
                }
            }
        }

        System.out.println("The shortest disance = "+minDistance);
        setPenColor(BLUE);
        setPenRadius(0.005);
        a.drawTo(b);
        show();




//        int x0 = Integer.parseInt(args[0]);
//        int y0 = Integer.parseInt(args[1]);
//        int n = Integer.parseInt(args[2]);
//
//        setCanvasSize(500, 500);
//        setXscale(0, 100);
//        setYscale(0, 100);
//        setPenRadius(0.005);
//        enableDoubleBuffering();
//
//        Point2D[] points = new Point2D[n];
//        for (int i = 0; i < n; i++) {
//            int x = StdRandom.uniform(100);
//            int y = StdRandom.uniform(100);
//            points[i] = new Point2D(x, y);
//            points[i].draw();
//            show();
//        }

        // draw p = (x0, x1) in red
//        Point2D p = new Point2D(x0, y0);
//        setPenColor(RED);
//        setPenRadius(0.02);
//        p.draw();
//
//
//        // draw line segments from p to each point, one at a time, in polar order
//        setPenRadius();
//        setPenColor(BLUE);
//        Arrays.sort(points, p.polarOrder());
//        for (int i = 0; i < n; i++) {
//            p.drawTo(points[i]);
//            show();
//            pause(100);
//        }
    }
}
