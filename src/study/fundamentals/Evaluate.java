package study.fundamentals;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;

public class Evaluate
{
    public static void main(String[] args){

        String s = null;
        double value = 0;
        Stack<String> operatorStack = new Stack<>();
        Stack<Double> operandStack = new Stack<>();
        String exprStr = StdIn.readString();
        char[] exprArr = exprStr.toCharArray();
        //while( !(s = StdIn.readString()).equals(";") ){
        for(int i=0;i<exprArr.length;i++){
            s = String.valueOf(exprArr[i]);
            if(s.equals("(")) continue;
            else if(s.equals("+")) operatorStack.push(s);
            else if(s.equals("-")) operatorStack.push(s);
            else if(s.equals("*")) operatorStack.push(s);
            else if(s.equals("/")) operatorStack.push(s);
            else if(s.equals(")")){
                double operand1 = operandStack.pop();
                double operand2 = operandStack.pop();
                String operator = operatorStack.pop();
                if(operator.equals("+")) value = operand1 + operand2;
                if(operator.equals("-")) value = operand1 - operand2;
                if(operator.equals("*")) value = operand1 * operand2;
                if(operator.equals("/")) value = operand1 / operand2;

                operandStack.push(value);
            }
            else operandStack.push(Double.parseDouble(s));
        }

        System.out.println(operandStack.pop());

    }
}
