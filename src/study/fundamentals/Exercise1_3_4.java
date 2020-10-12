package study.fundamentals;

import edu.princeton.cs.algs4.StdIn;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Exercise1_3_4 {

    private static List<Character> keywords = new ArrayList<>();
    static {
        keywords.add(')');
        keywords.add(']');
        keywords.add('}');
    }

    public static void main(String[] args) {


        while (true) {
            System.out.println("Please enter a Parentheses to evaluate: ");

            String input = StdIn.readLine();

            LinkedListStack<Character> stack = new LinkedListStack<>();


            char[] charArr = input.toCharArray();

            boolean result = true;

            boolean mapped = true;

            for (char c : charArr) {

                if (keywords.contains(c)) {
                    if (pair(stack, c))
                        continue;
                    else {
//                    mapped = false;
                        stack.push(c);
                        break;

                    }
                } else
                    stack.push(c);


            }

//        if(mapped && !stack.isEmpty())
//            result = false;
            if (stack.isEmpty())
                System.out.println(true);
            else
                System.out.println(false);
        }
    }


    private static boolean pair(LinkedListStack<Character> stack, char c){
        if(stack.isEmpty())
            return false;

        boolean result = true;
        switch (c) {
            case ')':
                if(stack.pop() != '(') {
                    result = false;
                }
                break;



            case ']':
                if(stack.pop() != '[') {
                    result = false;
                }
                break;


            case '}':
                if(stack.pop() != '{') {
                    result = false;
                }
                break;

            default: throw new IllegalArgumentException("Ilegal closing parentheses !!!");
        }

        return  result;
    }

    private static boolean pair(char topChar, char c) {

        boolean result = true;
        switch (c) {
            case ')':
                if(topChar != '(') {
                    result = false;
                }
                break;



            case ']':
                if(topChar != '[') {
                    result = false;
                }
                break;


            case '}':
                if(topChar != '{') {
                    result = false;
                }
                break;

            default: throw new IllegalArgumentException("Ilegal closing parentheses !!!");
        }

        return  result;
    }
}
