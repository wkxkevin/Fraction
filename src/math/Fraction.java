package math;
import math.Factorization.*;

public class Fraction {
    Factorization numerator;
    Factorization denominator;

    public Fraction() {
        numerator = new Factorization();
        denominator = new Factorization();
    }

    public Fraction(int numerator) {
        this(new Factorization(numerator), new Factorization());
    }

    public Fraction(Factorization numerator) {
        this(numerator, new Factorization());
    }

    public Fraction(int numerator, int denominator) {
        this(new Factorization(numerator), new Factorization(denominator));
    }

    public Fraction(Factorization numerator, int denominator) {
        this(numerator, new Factorization(denominator));
    }

    public Fraction(int numerator, Factorization denominator) {
        this(new Factorization(numerator), denominator);
    }

    public Fraction(Factorization numerator, Factorization denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
        Reduce();
    }

    //simplifies a fraction
    private void Reduce() {
        Factorization common = numerator.GCD(denominator);
        numerator = math.Factorization.divide(numerator, common);
        denominator = divide(denominator, common);
    }

    //adds a fraction, always returns simplified fraction
    public Fraction add(Fraction second) {
        Reduce();
        return this;
    }

    public String toString() {
        return numerator.num + "/" + denominator.num;
    }
}
