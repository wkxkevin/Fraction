package math;

/**
 * Factorization
 */

public class General {

    //Find GCD, Always assume first > second
    public static int GCD(int first, int second) {
        if(first < second)
            return GCD(second, first);
        if(first%second == 0)
            return second;
        if(first == 0 || second == 0)
            return 1;
        while(first > second) {
            first -= second;
        }
        return GCD(second, first);
    }

    //Finds LCM
    public static int LCM(int first, int second) {
        return first*second/GCD(first, second);
    }



}
