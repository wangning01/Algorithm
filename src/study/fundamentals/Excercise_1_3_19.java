package study.fundamentals;

public class Excercise_1_3_19 {

    public static void main(String[] args){

        LinkedList<String> list = new LinkedList<>();

        list.add("Hello");
        list.add("world");
        list.add("tiger");

        for(String item: list){
            System.out.println(item);
        }

        list.delete(1);
        list.delete(1);
        list.delete(1);


        for(String item: list){
            System.out.println(item);
        }

    }

}
