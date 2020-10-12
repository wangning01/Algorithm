package study.algorithm;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class OneTwoNine {

    public static int rank(int key, int[] a, Counter counter)
    { // Array must be sorted.
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi)
        { // Key is in a[lo..hi] or not present.
            counter.increment();
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid]) hi = mid - 1;
            else if (key > a[mid]) lo = mid + 1;
            else return mid;
        }
        return -1;
    }

    public static void main(String[] args)
    {
        int[] whitelist = In.readInts(args[0]);
        Arrays.sort(whitelist);
        Counter  counter = new Counter();
        while (!StdIn.isEmpty())
        { // Read key, print if not in whitelist.
            counter.reset();
            int key = StdIn.readInt();

            if (rank(key, whitelist, counter) < 0){
                System.out.println("key: "+key +" not found. Examined "+counter.getCount()+" times.");
            }else
                System.out.println("key: "+key +" found. Examined "+counter.getCount()+" times.");


        }
    }


    private static class Counter {
         int counter = 0;

         public void increment(){

            this.counter++;
        }

        public void reset(){
             this.counter = 0;
        }

        public int getCount() {
            return counter;
        }
    }
}
