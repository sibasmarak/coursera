import java.util.*;

public class LCS2 {

    private static int lcs2(int[] a, int[] b) {
        //Write your code here
    	int lengthA = a.length, lengthB = b.length;
    	//System.out.println(lengthA + " " + lengthB) ;
    	int DP[][] = new int[lengthA+1][lengthB+1];
    	for(int i=0;i<lengthA+1;i++)
    	{
    			DP[i][0] = 0;
    	}
    	for(int j=0;j<lengthB+1;j++)
    	{
    			DP[0][j] = 0;
    	}
    	
    	for (int i = 1; i < lengthA+1; i++) 
   	  	{
   		  for(int j = 1;j < lengthB+1; j++)
   		  {
   			  int DPsame = Integer.MIN_VALUE, DPup = Integer.MIN_VALUE,
   					  DPside = Integer.MIN_VALUE;
   			  if(a[i-1] == b[j-1]) {
   				 DP[i][j] = DP[i-1][j-1]+1;
   			  }
   				 
   			  else if(a[i-1] != b[j-1]) {
   				 DPsame = DP[i-1][j-1];
   				 DPup = DP[i-1][j];
   				 DPside = DP[i][j-1];	
      			 DP[i][j] = max(DPsame, DPside, DPup);
   			  }
   		  }
   	  }
//    	for (int i = 0; i < lengthA+1; i++) {
//    		for (int j = 0; j < lengthB+1; j++)
//    		{
//    			System.out.print(DP[i][j] + " ");
//    		}
//    		System.out.println();
//			
//		}
        return DP[lengthA][lengthB];
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
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        int m = scanner.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = scanner.nextInt();
        }

        System.out.println(lcs2(a, b));
    }
}

