import java.util.*;

public class FibonacciPartialSum {
    private static long getFibonacciPartialSumNaive(long from, long to) 
    {
    	 to = to%60;
    	 from = from%60;

         int previous = 0;
         int current  = 1;
         for (int i = 0; i < from-1; ++i) {
             int tmp_previous = previous;
             previous = current;
             current = (tmp_previous + previous +1)%10;
         }
         int sumTillFrom = previous;
         int previous2 = 0;
         int current2 = 1;

         for(int i=0; i<to;i++)
         {
        	 int tmp_previous = previous2;
             previous2 = current2;
             current2 = (tmp_previous + previous2 +1)%10;
         }
         if(previous2 >= sumTillFrom)
        	 return previous2-sumTillFrom;
         else
        	 return previous2 + 10 - sumTillFrom;
		 
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long from = scanner.nextLong();
        long to = scanner.nextLong();
        System.out.println(getFibonacciPartialSumNaive(from, to));
    }
}

