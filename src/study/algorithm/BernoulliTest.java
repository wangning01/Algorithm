package study.algorithm;

import edu.princeton.cs.algs4.StdRandom;

public class BernoulliTest {

    public static void main(String[] args){

        double p = 0.4d;
        int numTrue=0;
        int numFalse=0;
        int totalTrials=20000;

        System.out.println("This trial is with probability of "+p);
        System.out.println("The total trials is "+totalTrials);

        for(int i=0;i<totalTrials;i++){
            if(StdRandom.bernoulli(p))
                numTrue++;
            else
                numFalse++;
        }



        System.out.println("This trial ends with number of TRUEs: "+numTrue);
        System.out.println("This trial ends with number of FALSEs: "+numFalse);
        System.out.println("The probability of this expriment is: "+numTrue*1.0/(numTrue+numFalse)*1.0);



    }
}
