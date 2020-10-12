package study.fundamentals;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.function.Consumer;

public class FixedCapacityStack<Item> implements Iterable<Item> {

    Item[] array = null;
    int pointer = 0;

    public FixedCapacityStack(int size){
        this.array = (Item[])new Object[size];
    }

    public void push(Item s) throws Exception {
        if( (pointer) == this.array.length ){
            System.out.println("Max capacity reached. Doubling size to: " + 2*array.length);
            array = resize(2*array.length);
        }
//            throw new Exception("Max capacity reached!");
        array[pointer++] = s;
    }

    private Item[] resize(int max) {

        Item[] temp = (Item[]) new Object[max];
        for(int i=0;i<array.length;i++){
            temp[i] = array[i];
        }
        array = temp;
        System.out.println("Stack resized to " + max);
        return array;

    }


    public Item pop() throws Exception {
//        pointer--;
        if(pointer == 0)
            throw new Exception("No more string to pop");
        Item value = array[--pointer];
        array[pointer] = null;
        return  value;

    }

    public boolean isEmpty(){
        return (pointer == 0);
    }

    public int size(){
        return pointer;
    }



    @Override
    public void forEach(Consumer<? super Item> action) {
        for(Item item: this){
            System.out.println(item);
        }
    }

    @Override
    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<Item>{

        private int itIdx = pointer;

        @Override
        public boolean hasNext() {
            return itIdx > 0;
        }

        @Override
        public Item next() {
            return array[--itIdx];
        }


    }

    public Item peek(){
        return this.array[pointer-1];
    }

    public static void main(String[] args) throws Exception {
        FixedCapacityStack<String> s = new FixedCapacityStack<String>(5);
        s.push("1");
        s.push("2");
        s.push("3");

        System.out.println(s.peek());


//        while (!StdIn.isEmpty())
//        {
//            String item = StdIn.readString();
//            if (!item.equals("-"))
//                s.push(item);
//            else if (!s.isEmpty()) StdOut.print(s.pop() + " ");
//
//            if (item.equals(";")) {
//                break;
//            }
//        }
//        StdOut.println("(" + s.size() + " left on stack)");
//
//        s.forEach(s1 -> System.out.println("from outside" + s1));


    }
}
