import math.General.*;
import java.util.*;

public class Client {
    public static void main(String[] args) {
        System.out.println(math.General.GCD(1342142,61234));
        ArrayList<Pair> prim = math.General.primeFact(1000);
        for(Pair p : prim) {
            System.out.println(p);
        }
    }
}
