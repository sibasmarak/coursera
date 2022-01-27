import java.util.*;

public class GCD {
  private static int gcd_naive(int a, int b) 
  {
	  if(a == 0)
		  return b;
	  else if(b==0)
		  return a;
	  if(a>b)
		  return gcd_naive(a%b, b);
	  else
		  return gcd_naive(a, b%a);
  }

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();

    System.out.println(gcd_naive(a, b));
  }
}
