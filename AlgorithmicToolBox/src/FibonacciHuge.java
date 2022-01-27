import java.util.*;

public class FibonacciHuge {
    private static long getPeriod(long n, long m) 
    {
        long previous = 0;
        long current  = 1;

        for (long i = 0; i < m*m; i++) 
        {
        	long newcurrent = (previous+current) % m;
            previous = current;
            current = newcurrent;
            if(previous==0 && current==1)
            {
            	return i+1;
            }
        }
		return 1;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();
        long period = getPeriod(n, m);
        int index = (int) (n%period);
        if(index==0)
        	System.out.println(0);
        else 
        {
        int DP[] = new int[index+1];
        DP[0] = 0;
        DP[1] = 1;
        for(int i=2;i<index+1;i++)
        {
        	DP[i] = (DP[i-1] +DP[i-2]) % (int)m;
        }
        System.out.println(DP[index]);
        }
    }
}

