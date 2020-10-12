package study.algorithm;

import com.sun.org.apache.xpath.internal.operations.Bool;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;

public class OneOneThirty {

    public static void main(String[] args){

        int N=10;
        Boolean[][] twoDimentionArry = new Boolean[N][N];


        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(gcd(i,j)==1)
                    twoDimentionArry[i][j]=true;
                else
                    twoDimentionArry[i][j]=false;
            }
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                System.out.print("["+i+"]"+"["+j+"]="+twoDimentionArry[i][j]+"  ");
            }
            System.out.println();
        }

    }

    private static int gcd(int p,int q){
        if(q==0) return p;
        int r=p%q;
        return gcd(q,r);
    }
}
