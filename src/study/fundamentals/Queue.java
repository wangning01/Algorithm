package study.fundamentals;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class Queue<Item> implements Iterable<Item>{

    Node<Item> first;
    Node<Item> last;
    int size = 0;



    private class Node<Item> {
        public Item item;
        public Node next;
    }

    public void enqueue(Item item){
        Node<Item> node = new Node<>();
        node.item = item;
        if(last == null) {
            first = node;
            last = node;
        }else{
            last.next = node;
            last = node;
        }

        size++;
    }

    public Item dequeue() throws IllegalAccessException {
        if(first == null){
            throw new IllegalAccessException("No more items in queue.");
        }
        Item item = first.item;
        first = first.next;
        size--;

        if(isEmpty())
            last = null;

        return item;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return (size==0);
    }

    @Override
    public Iterator<Item> iterator() {
        return new QueueIterator<Item>();
    }

    private class QueueIterator<Item> implements Iterator{

        private Node<Item> pointer;

        private QueueIterator() {
            this.pointer = (Node<Item>) first;
        }

        @Override
        public boolean hasNext() {
            return (this.pointer!=null);
        }

        @Override
        public Object next() {
            Item item = this.pointer.item;
            this.pointer = this.pointer.next;

            return item;
        }
    }

    public static void main(String[] args) throws IllegalAccessException { // Create a queue and enqueue/dequeue strings.
        Queue<String> q = new Queue<String>();
//        while (!StdIn.isEmpty()) {
//            String item = StdIn.readString();
//            if (!item.equals("-"))
//                q.enqueue(item);
//            else if (!q.isEmpty()) StdOut.print(q.dequeue() + " ");
//            else
//                break;
//        }
//        StdOut.println("(" + q.size() + " left on queue)");

        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-"))
                q.enqueue(item);
            else if (!q.isEmpty()) {
                Iterator iterator = q.iterator();
                while(iterator.hasNext()){
                    StdOut.println(iterator.next());
                }
            }
            else
                break;
        }
        StdOut.println("(" + q.size() + " left on queue)");
    }

}
