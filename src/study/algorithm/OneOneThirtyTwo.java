package study.algorithm;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class OneOneThirtyTwo {

    public static void main(String[] args) throws IOException {

        // Read double values from a file and save them into array of Double
        String path="/Users/wangn/IdeaProjects/Algorithm/exercise_rltd_files/OneOneThirtyTwo_0.txt";
        BufferedReader br = new BufferedReader(new FileReader(new File(path)));

        List<Double> doubleList = new ArrayList<Double>(10);
        String line=null;
        while( (line = br.readLine()) != null){
            doubleList.add(Double.valueOf(line));
        }
        Double[] doubleArray =   doubleList.toArray(new Double[doubleList.size()]);




        // Read l(low value),  r(high value) and N(number of intervals) from command line
        System.out.println("Please enter low value:");
        double l = StdIn.readDouble();

        System.out.println("Please enter high value:");
        double r = StdIn.readDouble();

        System.out.println("Please enter number of intervals:");
        int N = StdIn.readInt();


        // Start plotting the histogram

        int[] histogram = new int[N];
        // Determine each value in array falling into which interval.
        for(Double ele: doubleArray){
            int i=determineIntervalNum(ele,l,r,N);
            histogram[i]++;
        }

        int min=0;
        int max=0;

        for(int i=0;i<histogram.length;i++){
            if(histogram[i]<min)
                min=histogram[i];
            if(histogram[i]>max)
                max=histogram[i];
        }


        for (int i = 0; i < N; i++)
        {
            double x = 0.5/N+1.0*i/N;
            double y = (convertRange(histogram[i],min,max))/2.0;
            double rw = 0.5/N;
            double rh = (convertRange(histogram[i],min,max))/2.0;
            StdDraw.filledRectangle(x, y, rw, rh);
        }



//        int n = 5;
//        double[] a = new double[n];
//        for (int i = 0; i < n; i++)
//            a[i] = StdRandom.random();
//        for (int i = 0; i < n; i++)
//        {
//            double x = 0.5/n+1.0*i/n;
//            double y = a[i]/2.0;
//            double rw = 0.5/n;
//            double rh = a[i]/2.0;
//            StdDraw.rectangle(x, y, rw, rh);
//        }

    }

    private static double convertRange(int target, int min, int max){
        //        (b-a)(x - min)
        //        f(x) = --------------  + a
        //        max - min
        return (1.0-0.0)*(target-min)/(max-min) + 0.0;

    }

    private static int determineIntervalNum(double element,double low, double high, double N){

        int result =(int)((element-low)/( (high-low)/N));
        return result;

    }



}