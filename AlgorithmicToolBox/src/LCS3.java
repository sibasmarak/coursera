import java.util.*;

public class LCS3 {

    private static int lcs3(int[] a, int[] b, int[] c) {
        //Write your code here
    	int lengthA = a.length, lengthB = b.length, lengthC = c.length;
    	int DP[][][] = new int[lengthA+1][lengthB+1][lengthC+1];
    	
    	for(int i=1;i<lengthA+1;i++)
    	{
    		for(int j=1;j<lengthB+1;j++)
    		{
    			for(int k=1;k<lengthC+1;k++)
    			{
    				if(a[i-1] == b[j-1] && a[i-1] == c[k-1])
    					DP[i][j][k] = DP[i-1][j-1][k-1] + 1;
    				else 
    				{
    					DP[i][j][k] = max(DP[i-1][j][k], DP[i][j-1][k],
    							DP[i][j][k-1]);
    				}
    			}
    		}
    	}
    	return DP[lengthA][lengthB][lengthC];
    }
    private static int max(int a, int b, int c) {
		// TODO Auto-generated method stub
    	if(a>=b && a>=c)
    		return a;
    	else if(b>=a && b>=c)
    		return b;
    	else if(c>=a && c>=b)
    		return c;
		return 0;
	}

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int an = scanner.nextInt();
        int[] a = new int[an];
        for (int i = 0; i < an; i++) {
            a[i] = scanner.nextInt();
        }
        int bn = scanner.nextInt();
        int[] b = new int[bn];
        for (int i = 0; i < bn; i++) {
            b[i] = scanner.nextInt();
        }
        int cn = scanner.nextInt();
        int[] c = new int[cn];
        for (int i = 0; i < cn; i++) {
            c[i] = scanner.nextInt();
        }
        System.out.println(lcs3(a, b, c));
    }
}

