package study.fundamentals;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Excercise_1_3_11
{

    public static void main(String[] args){
        StdOut.println("Please enter a PostFix expression:");
        String postFix = StdIn.readString();
        LinkedListStack<String> stack = new LinkedListStack<>();

        for(char c: postFix.toCharArray()){
            if(c == '+'){
                int opd1 = Integer.valueOf(stack.pop());
                int opd2 = Integer.valueOf(stack.pop());
                stack.push(String.valueOf(opd1+opd2));
            }else if(c== '-'){
                int opd1 = Integer.valueOf(stack.pop());
                int opd2 = Integer.valueOf(stack.pop());
                stack.push(String.valueOf(opd1-opd2));
            }else if(c == '*'){
                int opd1 = Integer.valueOf(stack.pop());
                int opd2 = Integer.valueOf(stack.pop());
                stack.push(String.valueOf(opd1*opd2));
            }else if(c == '/'){
                int opd1 = Integer.valueOf(stack.pop());
                int opd2 = Integer.valueOf(stack.pop());
                stack.push(String.valueOf(opd1/opd2));
            }else
            {
                stack.push(String.valueOf(c));
            }
        }

        StdOut.println(stack.pop());
    }
}
