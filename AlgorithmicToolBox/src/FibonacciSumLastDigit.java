import java.util.*;

public class FibonacciSumLastDigit {
    private static long getFibonacciSumNaive(long n) {
    	 if (n <= 1)
             return n;

         int previous = 0;
         int current  = 1;
         n = n%60;
         for (int i = 0; i < n; ++i) {
             int tmp_previous = previous;
             previous = current;
             current = (tmp_previous + previous +1)%10;
         }

         return previous;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long s = getFibonacciSumNaive(n);
        System.out.println(s);
    }
}

