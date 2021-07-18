package math;
import math.Factorization;

public class Fraction {
    Factorization numerator;
    Factorization denominator;

    public Fraction() {
        numerator = new Factorization();
        denominator = new Factorization();
    }

    public Fraction(int numerator) {
        this.numerator = new Factorization(numerator);
        denominator = new Factorization();
    }

    public Fraction(int numerator, int denominator) {
        this.numerator = new Factorization(numerator);
        this.denominator = new Factorization(denominator);
    }

    public void Reduce() {
        Factorization common = numerator.GCD(denominator);
        numerator.divide(common);
        denominator.divide(common);
    }

    //adds a fraction, always returns simplified fraction
    // public Fraction add(Fraction second) {}
}
