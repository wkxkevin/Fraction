package math;
import math.Factorization.*;

/**
 * Fraction
 */
public class Fraction {
    Factorization numerator;
    Factorization denominator;

    public Fraction() {
        numerator = new Factorization(1);
        denominator = new Factorization(1);
    }

    public Fraction(int numerator) {
        this.numerator = new Factorization(numerator);
        denominator = new Factorization(1);
    }

    public Fraction(int numerator, int denominator) {
        this.numerator = new Factorization(numerator);
        this.denominator = new Factorization(denominator);
    }

    public void Reduce() {
        Factorization common = new Factorization(General.GCD(numerator.num, denominator.num));
        numerator.times(num);
    }

    //adds a fraction, always returns simplified fraction
    public Fraction add(Fraction second) {
        //take the common denominator
        //denominator = LCM()
    }
}
