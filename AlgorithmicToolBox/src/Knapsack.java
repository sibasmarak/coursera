import java.util.*;

public class Knapsack {
    static int optimalWeight(int W, int[] w) {
        //write you code here
        int result = 0, n = w.length;
        //DP will store the value_Max
        int DP[][] = new int[n+1][W+1];
        for(int i=0;i<n+1;i++)
        {
        	for(int j =0;j<W+1;j++)
        	{
        		if(i==0 || j==0)
        			DP[i][j] = 0;
        		else 
        		{
        			int dp = 0;
        			//include the i-th item and add its value
        			//or else exclude the i-th item
        			if(w[i-1]<=j)
        				dp = DP[i-1][j-w[i-1]] + w[i-1];
        			DP[i][j] = max(dp, DP[i-1][j]);
        		}
        	}
        }
        
        return DP[n][W];
    }

    private static int max(int a, int b) {
		// TODO Auto-generated method stub
    	return (a>b)?a:b;
	}

	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int W, n;
        W = scanner.nextInt();
        n = scanner.nextInt();
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = scanner.nextInt();
        }
        System.out.println(optimalWeight(W, w));
    }
}

