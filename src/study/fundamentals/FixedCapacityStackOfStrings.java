package study.fundamentals;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class FixedCapacityStackOfStrings {

    String[] array = null;
    int pointer = 0;

    public FixedCapacityStackOfStrings(int size){
        this.array = new String[size];
    }

    public void push(String s) throws Exception {
        if( (pointer) == this.array.length )
            throw new Exception("Max capacity reached!");
        array[pointer++] = s;
    }


    public String pop() throws Exception {
//        pointer--;
        if(pointer == 0)
            throw new Exception("No more string to pop");
        return  array[--pointer];

    }

    public boolean isEmpty(){
        return (pointer == 0);
    }

    public boolean isFull() {
        return pointer==array.length;
    }


    public int size(){
        return pointer;
    }

    public static void main(String[] args) throws Exception {
        FixedCapacityStackOfStrings s;
        s = new FixedCapacityStackOfStrings(100);
        while (!StdIn.isEmpty())
        {
            String item = StdIn.readString();
            if (!item.equals("-"))
                s.push(item);
            else if (!s.isEmpty()) StdOut.print(s.pop() + " ");
            else
                break;
        }
        StdOut.println("(" + s.size() + " left on stack)");
    }
}
