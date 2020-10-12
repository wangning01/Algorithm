package study.fundamentals;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class LinkedListStack<Item> {

    Node first;
    int size = 0;

    private class Node<Item> {
        public Item item;
        public Node next;
    }

    public void push(Item item){
        Node node = new Node();
        node.item = item;

        Node oldFirst = first;
        first = node;
        first.next = oldFirst;

        size++;
    }

    public Item pop(){
        if(first == null)
            throw new IllegalStateException("No more items in stack!");

        Node<Item> result = first;

        first = first.next;

        size--;

        return result.item;
    }

    public int size(){
        return size;
    }


    public boolean isEmpty(){
        return size == 0;
    }

    public static void main(String[] args) throws Exception {
        LinkedListStack<String> s = new LinkedListStack<String>();
        while (!StdIn.isEmpty())
        {
            String item = StdIn.readString();
            if (!item.equals("-") && !item.equals(";"))
                s.push(item);
            else if ( item.equals("-") && !s.isEmpty() )
                StdOut.print(s.pop() + " ");
            else if (item.equals(";")) {
                break;
            }
        }
        StdOut.println("(" + s.size() + " left on stack)");

//        for(String item: s){
//            System.out.println(item);
//        }

    }
}
