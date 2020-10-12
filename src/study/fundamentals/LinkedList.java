package study.fundamentals;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.Optional;

public class LinkedList<Item> implements Iterable<Item>{

    private Node first;
    private Node last;
    private int size = 0;
    private Node currPointer;



    public class Node{
        Item value;
        Node next;
    }

    public void removeAfter(Node node){

        if(node.next != null)
            node.next = node.next.next;
    }

    public Optional<Node> getNode(int nTH){

        Node beforeFirst = new Node();
        beforeFirst.next = first;
        Node pointer = beforeFirst;

        if(this.size < nTH)
            return Optional.of(null);

        for(int i=0;i<nTH;i++){
            pointer = pointer.next;
        }

        return Optional.of(pointer);
    }

//    private Optional<Node> find(Node node) {
//
//        Iterator it = this.iterator();
//        while(it.hasNext()){
//            if(it.next() == node)
//                return Optional.of(node);
//        }
//
//        return Optional.of(null);
//
//    }

    public void removeLast(){

        if(first == null)
            return;

        Node tempNode = new Node();
        tempNode.next = first;

        Node pointer = tempNode;

        while(pointer.next.next != null){
            pointer = pointer.next;
        }

        pointer.next = null;

    }

    public void delete(int nTH) {
        if (nTH < 1 || nTH > size)
            throw new RuntimeException("Item does not exist at index " + nTH);

        if (nTH == 1) {
            first = first.next;
        } else {
            Node pointer = new Node();
            Node beforeFirst = new Node();
            beforeFirst.next = first;
            pointer = beforeFirst;


            for (int i = 0; i < nTH - 1; i++) {
                pointer = pointer.next;
            }

            pointer.next = pointer.next.next;
        }
    }

    public boolean find(String key){

        Node beforeFirst = new Node();
        beforeFirst.next = first;
        Node pointer = beforeFirst;

        while(pointer != null){
            if(pointer.value != null && pointer.value.equals(key))
                return true;

            pointer = pointer.next;
        }

        return false;
    }


    public synchronized void add(Item item){
        Node node = new Node();
        node.value = item;

        if(first == null){
            first = node;
            last = node;
        }else {
            last.next = node;
            last = node;
        }

        size++;
    }

    public int size(){
        return this.size;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator<Item>() {
            @Override
            public boolean hasNext() {

                boolean result = false;
               if(currPointer == null)
                   result =  first != null;
               else
                   result =  currPointer.next != null;

               if(result == false)
                   currPointer = null;

               return result;

            }

            @Override
            public Item next() {
                if(currPointer == null){
                    currPointer = first;
                    return currPointer.value;
                }else{
                    currPointer = currPointer.next;
                    return currPointer.value;
                }


            }

            @Override
            public boolean hasPrevious() {
                return false;
            }

            @Override
            public Item previous() {
                return null;
            }

            @Override
            public int nextIndex() {
                return 0;
            }

            @Override
            public int previousIndex() {
                return 0;
            }

            @Override
            public void remove() {

            }

            @Override
            public void set(Item item) {

            }

            @Override
            public void add(Item item) {

            }
        };
    }

    public static void main(String[] args){

        LinkedList<String> list = new LinkedList<>();
//        list.add("hello");
//        list.add("world");
//        list.add("tiger");


        for(String item: list){
            System.out.println(item);
        }

        System.out.println(list.size);
    }
}


