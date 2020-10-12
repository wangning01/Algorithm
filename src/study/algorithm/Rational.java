package study.algorithm;

public class Rational {

    private long numerator;
    private long denominator;

    public long getNumerator() {
        return numerator;
    }

    public long getDenominator() {
        return denominator;
    }

    public Rational(long numerator, long denominator) throws Exception {
        this.numerator = numerator;
        this.denominator = denominator;

        if(Math.abs(gcd(this.numerator, this.denominator)) != 1)
            throw new Exception("Invalid Rational number: "+"Numerator:"+this.numerator+" Denominator:"+this.denominator);
    }

    public  long gcd(long p, long q)
    {
        if (q == 0) return p;
        long r = p % q;
        return gcd(q, r);
    }

    public Rational plus(Rational b) throws Exception {
        long denominator = this.denominator * b.getDenominator();
        long numerator = this.numerator * b.getDenominator() + this.denominator *  b.getNumerator();

        return new Rational(numerator, denominator);
    }

    public Rational minus(Rational b) throws Exception {
        long denominator = this.denominator * b.getDenominator();
        long numerator = this.numerator * b.getDenominator() - this.denominator *  b.getNumerator();

        return new Rational(numerator, denominator);
    }

    public Rational times(Rational b) throws Exception {
        long denominator = this.denominator * b.getDenominator();
        long numerator = this.numerator * b.getNumerator();

        long gcd = gcd(numerator,denominator);
        numerator = numerator/gcd;
        denominator = denominator/gcd;

        return new Rational(numerator, denominator);
    }

    @Override
    public String toString(){
        return this.numerator+"/"+this.denominator;
    }

    public double value(){
        return Double.valueOf(this.numerator)/Double.valueOf(this.denominator);
    }

    public static void main(String[] args) throws Exception {

        Rational a = new Rational(2,3);
        Rational b = new Rational(7,8);

        Rational c = a.plus(b);
        System.out.println(c.toString());
        System.out.println(c.value());

        //System.out.println((new Rational(1,2)).gcd(-5,24));
        Rational d = a.minus(b);
        System.out.println(d.toString());
        System.out.println(d.value());

        Rational e = a.times(b);
        System.out.println(e.toString());
        System.out.println(e.value());

    }



}
