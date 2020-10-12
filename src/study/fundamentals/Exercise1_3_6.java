package study.fundamentals;

public class Exercise1_3_6 {

    public static void main(String[] args) throws Exception {

        FixedCapacityStack<String> stack = new FixedCapacityStack<>(5);
        Queue<String> queue = new Queue<>();

        queue.enqueue("1");
        queue.enqueue("2");
        queue.enqueue("3");
        queue.enqueue("4");
        queue.enqueue("5");

        while (!queue.isEmpty())
            stack.push(queue.dequeue());

        while (!stack.isEmpty())
            queue.enqueue(stack.pop());

        for(String s: queue){
            System.out.println(s);
        }





    }
}
