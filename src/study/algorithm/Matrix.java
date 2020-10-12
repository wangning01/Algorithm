package study.algorithm;

public class Matrix {

    public static double dot(double[] x, double[] y){
        if(x.length != y.length) {
            System.err.println("The length of 2 arrays has to be equal.");
            System.exit(1);
        }

        double result=0d;
        for(int i=0;i<x.length;i++){
            result+=x[i]*y[i];
        }

        return result;
    }

    public static double[][] mult(double[][] a, double[][] b){

        if(a.length<1 || b.length<1)
            return null;

        if(a[0].length<1 || b[0].length<1) {
            return null;
        }

        if(a[0].length != b.length)
            throw new IllegalArgumentException("The number of columns of array A has to equal the number of rows of array B");

        double[][] result = new double[a.length][b[0].length];

        double element=0d;
        for(int i=0;i<a.length;i++){
            {
                for (int j = 0; j < b[0].length; j++){
                    for (int k=0;k<b.length;k++){
                        element+=a[i][k]*b[k][j];
                    }
                    result[i][j]=element;
                    element=0;
                }
            }
        }

        return result;

    }


    public static void main(String[] args){

        // Test dot method
//        double[] x={1.0,2.0,3.0,4.0};
//        double[] y={1.0,2.0,3.0};
//
//        System.out.println("The dot product of x and y is: "+Matrix.dot(x,y));

        double[][] a = new double[2][3];
        a[0][0]=1;
        a[0][1]=2;
        a[0][2]=3;
        a[1][0]=4;
        a[1][1]=5;
        a[1][2]=6;

        double[][] b = new double[3][2];
        b[0][0]=1;
        b[0][1]=2;
        b[1][0]=3;
        b[1][1]=4;
        b[2][0]=5;
        b[2][1]=6;

        double[][] result = mult(a,b);




    }
}
