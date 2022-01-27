import java.util.Scanner;

public class ChangeDP {
    private static int getChange(int m) {
        if(m<=4)
        {
        	if(m==1)
        		return 1;
        	else if(m==2)
        		return 2;
        	else if(m==3)
        		return 1;
        	else if(m==4)
        		return 1;
        }
        int DP[] = new int[m+1];
        DP[0] = 0;
        DP[1] = 1;
        DP[2] = 1;
        DP[3] = 1;
        DP[4] = 1;
        for (int i = 5; i < DP.length; i++) {
			int x1 = DP[i-1] + 1;
			int x2 = DP[i-3] + 1;
			int x3 = DP[i-4] + 1;
			DP[i] = min(x1,x2,x3);
		}
        return DP[m];
    }

    private static int min(int m1, int m2, int m3) {
		// TODO Auto-generated method stub
    	if(m1<=m2 && m1<=m3)
    		return m1;
    	else if(m2<=m1 && m2<=m3)
    		return m2;
    	else if(m3<=m1 && m3<=m2)
    		return m3;
    	return 0;
    }

	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}

