import java.util.Scanner;

public class PlacingParentheses {
    private static long getMaximValue(String exp) {
      //write your code here
    	//convert String to an integer array
    	int n = exp.length()/2 + 1,i,j;
    	long finalMax = Long.MIN_VALUE,finalMin = Long.MAX_VALUE,
    			tempMax,tempMin;
    	char arr[] = exp.toCharArray();
    	long M[][] = new long[n][n];
    	long m[][] = new long[n][n];
    	for(i=0;i<n;i++)
    	{
    		M[i][i] = arr[2*i] - 48;
    		m[i][i] = arr[2*i] - 48;
    	}
    	for(int diag = 1; diag<n;diag++)
    	{
    		for(i=0;i<n-diag;i++)
    		{
    			j = i+diag;
    			finalMax = Long.MIN_VALUE;
    			finalMin = Long.MAX_VALUE;
    			for(int k=i;k<j;k++)
    			{
    				//k varies from i to j-1
    				long eval1 = eval(M[i][k], M[k+1][j], arr[2*k+1]);
    				long eval2 = eval(M[i][k], m[k+1][j], arr[2*k+1]);
    				long eval3 = eval(m[i][k], M[k+1][j], arr[2*k+1]);
    				long eval4 = eval(m[i][k], m[k+1][j], arr[2*k+1]);
    				tempMax = max(max(eval1, eval2), max(eval3, eval4));
    				tempMin = min(min(eval1, eval2), min(eval3, eval4));
    				if(tempMax>finalMax)
    					finalMax = tempMax;
    				if(tempMin < finalMin)
    					finalMin = tempMin;
    			}
    			M[i][j] = finalMax;
    			m[i][j] = finalMin;
    		}
    	}
//    	for(int p = 0;p<n;p++)
//    	{
//    		for(int q=0;q<n;q++)
//    		{
//    			System.out.print(M[p][q] + "\t");
//    		}
//    		System.out.println();
//    	}
//    	System.out.println();
//    	for(int p = 0;p<n;p++)
//    	{
//    		for(int q=0;q<n;q++)
//    		{
//    			System.out.print(m[p][q] + "\t");
//    		}
//    		System.out.println();
//    	}
      return M[0][n-1];
    }

    private static long min(long a, long b) {
		// TODO Auto-generated method stub
    	return (a<b)?a:b;
	}

	private static long max(long a, long b) {
		// TODO Auto-generated method stub
		return (a>b)?a:b;
	}

	private static long eval(long a, long b, char op) {
        if (op == '+') {
            return a + b;
        } else if (op == '-') {
            return a - b;
        } else if (op == '*') {
            return a * b;
        } else {
            assert false;
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String exp = scanner.next();
        System.out.println(getMaximValue(exp));
    }
}

