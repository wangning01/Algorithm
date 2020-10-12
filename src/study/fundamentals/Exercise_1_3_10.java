package study.fundamentals;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.List;

public class Exercise_1_3_10 {

    public static void main(String[] args){

        StdOut.println("Please enter an infix arithmatic expression:");

        String infix = StdIn.readString();

        LinkedListStack<Character> stack = new LinkedListStack<>();
        StringBuilder sb = new StringBuilder();

        char[] chars = infix.toCharArray();

        for (char c: chars) {

            char optr;
            if( c== '('){
                stack.push(c);
            }else if(c == ')'){
                while( (optr=stack.pop()) != '(') {
                    sb.append(optr);
                }
            }else if(c == '+' || c== '-'){
                while (stack.size() > 0 ){
                    optr = stack.pop();
                    if(optr == '*' || optr == '/')
                        sb.append(optr);
                    else{
                        stack.push(optr);
                        break;
                    }
                }
                stack.push(c);
            }else if(c == '*' || c=='/'){
                stack.push(c);
            }else{
                sb.append(c);
            }
        }

        while(stack.size > 0){
            sb.append(stack.pop());
        }

        StdOut.println(sb.toString());
    }
}
