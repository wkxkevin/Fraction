import math.Factorization.Pair;
import math.*;

public class Client {
    public static void main(String[] args) {
        System.out.println(General.GCD(1342142,61234));
        Factorization prim1 = new Factorization((int)(100*Math.random()));
        Factorization prim2 = new Factorization((int)(100*Math.random()));
        for(Pair p : prim1.factorization) {
            System.out.println(p);
        }
        System.out.println();
        for(Pair p : prim2.factorization) {
            System.out.println(p);
        }
        System.out.println();
        for(Pair p : prim1.GCD(prim2).factorization) {
            System.out.println(p);
        }

        Fraction frac = new Fraction(prim1, prim2);
        System.out.println(frac);
        System.out.println(frac);
    }
}
