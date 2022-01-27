import java.util.Scanner;

public class Fibonacci {
  private static long calc_fib(long n) 
  {
	  if(n<=1)
		  return n;
	  long previous = 0;
	  long current = 1;
	  for(long i=0;i<n-1;i++)
	  {
		  long temp_previous = previous;
		  previous = current;
		  current = (temp_previous+current);
	  }
	  return current;
  }

  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);
    long n = in.nextLong();
    System.out.println(calc_fib(n));
  }
}
