package study.algorithm;

import java.util.HashMap;

public class GetClassTest {
    public static void main(String[] args){

        HashMap<String, String> a = new HashMap<>();
        HashMap<String, String> b = new HashMap<>();

        if(a.getClass() == b.getClass())
            System.out.println("different object of same class returns same CLASS object");
        else
            System.out.println("different object of same class returns different CLASS object");

    }
}
