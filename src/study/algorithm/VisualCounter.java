package study.algorithm;

import edu.princeton.cs.algs4.StdDraw;

public class VisualCounter {

    private final int maxOperation;
    private final int maxAbs;
    private int count;
    private int numOperation;

    public VisualCounter(int maxOperation, int maxAbs){
        this.maxOperation = maxOperation;
        this.maxAbs = maxAbs;

        StdDraw.setXscale(0,this.maxOperation);
        StdDraw.setYscale(-this.maxAbs,this.maxAbs);
        StdDraw.setPenRadius(0.01);
        StdDraw.point(0,0);

    }

    public void increment(){
        if(this.count == this.maxAbs) {
            System.out.println("Count exceeded maxAbs: " + this.maxAbs);
            return;
        }

        if(this.numOperation == this.maxOperation){
            System.out.println("Number of operations exceeded max operations allowed: " + this.maxOperation);
            return;
        }

        this.count++;
        this.numOperation++;
        StdDraw.point(this.numOperation,this.count);

    }

    public void decrement(){
        if(this.count == -(this.maxAbs)) {
            System.out.println("Count exceeded minAbs: " + -this.maxAbs);
            return;
        }

        if(this.numOperation == this.maxOperation){
            System.out.println("Number of operations exceeded max operations allowed: " + this.maxOperation);
            return;
        }

        this.count--;
        this.numOperation++;

        StdDraw.point(this.numOperation,this.count);
    }

    public static void main(String[] args){

        VisualCounter vcounter = new VisualCounter(20,50);

        for(int i=0;i<10;i++){
            vcounter.increment();
        }

        for(int i=0;i<5;i++){
            vcounter.decrement();
        }



    }


}