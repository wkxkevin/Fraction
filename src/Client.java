import math.Factorization;
import math.Factorization.*;
import java.util.*;

public class Client {
    public static void main(String[] args) {
        System.out.println(math.General.GCD(1342142,61234));
        Factorization prim1 = new Factorization((int)(1000*Math.random()));
        Factorization prim2 = new Factorization((int)(1000*Math.random()));
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
    }
}
