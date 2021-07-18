package math;
import java.util.*;

public class Factorization {

    private static int[] primes =  {2, 3, 5, 7, 11, 13, 17, 19, 23, 29,
        31, 37, 41, 43, 47, 53, 59, 61, 67, 71,
        73, 79, 83, 89, 97, 101, 103, 107, 109, 113 ,
        127, 131, 137, 139, 149, 151, 157, 163, 167, 173,
        179, 181, 191, 193, 197, 199, 211, 223, 227, 229,
        233, 239, 241, 251, 257, 263, 269, 271, 277, 281,
        283, 293, 307, 311, 313, 317, 331, 337, 347, 349,
        353, 359, 367, 373, 379, 383, 389, 397, 401, 409,
        419, 421, 431, 433, 439, 443, 449, 457, 461, 463,
        467, 479, 487, 491, 499, 503, 509, 521, 523, 541,
        547, 557, 563, 569, 571, 577, 587, 593, 599, 601,
        607, 613, 617, 619, 631, 641, 643, 647, 653, 659,
        661, 673, 677, 683, 691, 701, 709, 719, 727, 733,
        739, 743, 751, 757, 761, 769, 773, 787, 797, 809,
        811, 821, 823, 827, 829, 839, 853, 857, 859, 863,
        877, 881, 883, 887, 907, 911, 919, 929, 937, 941,
        947, 953, 967, 971, 977, 983, 991, 997, 1009, 1013,
        1019, 1021, 1031, 1033, 1039, 1049, 1051, 1061, 1063, 1069,
        1087, 1091, 1093, 1097, 1103, 1109, 1117, 1123, 1129, 1151,
        1153, 1163, 1171, 1181, 1187, 1193, 1201, 1213, 1217, 1223};

    public class Pair {
        int base;
        int exp;

        public Pair() {
            base = 0;
            exp = 0;
        }

        public Pair(int base, int exp) {
            this.base = base;
            this.exp = exp;
        }

        public Pair deepCopy() {
            return new Pair(base, exp);
        }

        public String toString() {
            return "<" + base + ", " + exp + ">";
        }
    }

    public int num;
    public ArrayList<Pair> factorization;

    public Factorization() {
        num = 1;
        factorization = new ArrayList<Pair>();
    }

    public Factorization(int num) {
        this.num = num;
        factorization = findFacorization(num);
    }

    //finds the factorization of a number
    private ArrayList<Pair> findFacorization(int num) {
        factorization = new ArrayList<Pair>();
        int factorizationIndex = 0;
        for(int primeIndex = 0; num > 1; primeIndex++) {
            if(num%primes[primeIndex] == 0) {
                factorization.add(new Pair(primes[primeIndex], 0));
                while(num%primes[primeIndex] == 0) {
                    factorization.get(factorizationIndex).exp++;
                    num /= primes[primeIndex];
                }
                factorizationIndex++;
            }
        }
        return factorization;
    }

    //returns a deep copy of this class
    public Factorization deepCopy() {
        Factorization copy = new Factorization();
        copy.num = num;
        for(Pair p : factorization) {
            copy.factorization.add(p.deepCopy());
        }
        return copy;
    }

    //adds a number to the current factorization
    public Factorization add(int num) {
        this.num += num;
        factorization = findFacorization(this.num);
        return this;
    }

    public Factorization add(Factorization second) {
        return add(second.num);
    }

    //get the index of one of the factors
    public int getIndex(int base) {
        for(int i = 0; i < factorization.size(); i++) {
            if(factorization.get(i).base == base) {
                return i;
            }
        }
        return -1;
    }

    //multiplies the current factorization by another
    public Factorization times(Factorization second) {
        for(Pair p : second.factorization) {
            int idx = getIndex(p.base);
            if(idx == -1) {
                factorization.add(p);
            } else {
                factorization.get(idx).exp += p.exp;
            }
        }

        return this;
    }

    public Factorization times(int num) {
        return times(new Factorization(num));
    }

    //obtains the GCD of a matrix
    public Factorization GCD(Factorization second) {
        Factorization divisor = new Factorization();
        for(Pair p : factorization) {
            int idx = second.getIndex(p.base);
            if(idx != -1) {
                divisor.factorization.add(new Pair(second.factorization.get(idx).base, Math.min(second.factorization.get(idx).exp, p.exp)));
            }
        }
        return divisor;
    }

    //multiplies the current factorization by another
    public Factorization divide(Factorization second) {
        for(Pair p : second.factorization) {
            int idx = getIndex(p.base);
            if(idx == -1) {
                factorization.add(p);
            } else {
                factorization.get(idx).exp -= p.exp;
            }
        }

        return this;
    }

    public Factorization divide(int num) {
        return divide(new Factorization(num));
    }
}
