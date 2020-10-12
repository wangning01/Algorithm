package study.fundamentals;

import edu.princeton.cs.algs4.StdOut;
import sun.awt.image.ImageWatched;

public class Exercise_1_3_24 {

    public static void main(String[] args){

        LinkedList<String> list = new LinkedList<>();

        list.add("hello");
        list.add("world");
        list.add("tiger");

        LinkedList.Node node = list.getNode(3).get();
        list.removeAfter(node);

        for(String item: list){
            StdOut.println(item);
        }
    }
}
