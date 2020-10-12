package study.algorithm;

import edu.princeton.cs.algs4.StdIn;

public class OneTwoSix {

    public static void main(String[] args){
        System.out.println("Please enter String 1:");
        String s1 = StdIn.readString();

        System.out.println("Please enter String 2:");
        String s2 = StdIn.readString();

        if(s1.length() != s2.length()) {
            System.out.println("The input Strings are not circular rotation of each other!");
            System.exit(1);
        }

        if(s2.concat(s2).indexOf(s1) !=-1){

            System.out.printf("%s is circular rotation of %s",s1,s2);

        }else
            System.out.printf("%s is not circular rotation of %s",s1,s2);


    }
}
