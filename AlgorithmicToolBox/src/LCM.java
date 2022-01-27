import java.math.BigInteger;
import java.util.*;


public class LCM {
  private static BigInteger lcm_naive(int a, int b) 
  {
	BigInteger GCD = new BigInteger(""+gcd_naive(a, b));
	BigInteger A = new BigInteger(""+a);
	BigInteger B = new BigInteger(""+b);
	BigInteger prod = A.multiply(B);
	return prod.divide(GCD);
  }
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

    System.out.println(lcm_naive(a, b));
  }
}
