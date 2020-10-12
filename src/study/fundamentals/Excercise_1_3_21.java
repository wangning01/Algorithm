package study.fundamentals;

import edu.princeton.cs.algs4.StdOut;

public class Excercise_1_3_21 {

    public static void main(String[] args){

        LinkedList<String> list = new LinkedList<>();

        list.add("Hello");
        list.add("World");
        list.add("Tiger");
        list.add("Ling");
        list.add("HUZI");

        if(list.find("Hello"))
            StdOut.println("Hello Found!");

        if(!list.find("HELLO"))
            StdOut.println("HELLO not found!");


    }
}
