package study.fundamentals;

import edu.princeton.cs.algs4.StdIn;
import sun.awt.image.ImageWatched;

public class Exercise_1_3_9 {

    public static void main(String[] args) {

        System.out.println("Please enter your partial infix expression:");
        String input = StdIn.readString();

        char[] inputArray = input.toCharArray();

        if (!isCharEligible(inputArray)) {
            System.out.println("Invalid chars in input. Exiting...");
            return;
        }

        LinkedListStack<String> operandStack = new LinkedListStack<>();
        LinkedListStack<String> operatorStack = new LinkedListStack<>();

        for (char c : inputArray) {
            switch (c) {
                case ')':
                    String operand1 = operandStack.pop();
                    String operand2 = operandStack.pop();
                    String operator = operatorStack.pop();
                    String newOperand = "(" + operand2 + operator + operand1 + ")";
                    operandStack.push(newOperand);
                    break;
                default:
                    if (isOperator(c)) {
                        operatorStack.push(String.valueOf(c));
                    }
                    if (isNumeric(c)) {
                        operandStack.push(String.valueOf(c));
                    }
            }
        }

        System.out.println(operandStack.pop());
    }

    private static boolean isNumeric(char c) {

        return (c>='0' && c<='9');
    }

    private static boolean isOperator(char c) {

        return  (c=='+') || (c=='-') || (c=='*');
    }


    private static boolean isCharEligible(char[] inputArray) {

        for(char ch: inputArray) {

            boolean eligible = (ch>='0' && ch<='9') || (ch=='+') || (ch=='-') || (ch=='*') || (ch==')');
            if(!eligible)
                return false;
        }

        return true;
    }





}
