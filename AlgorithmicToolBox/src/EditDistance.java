import java.util.*;

class EditDistance {
  public static int EditDistance(String s, String t) {
    //write your code here
	  char sArr[] = s.toCharArray();
	  char tArr[] = t.toCharArray();
	  int lengthS = s.length(), lengthT = t.length();
	  int DP[][] = new int[s.length()+1][t.length()+1];
	  
	  for(int i=0;i<lengthS+1;i++)
		  DP[i][0] = i;
	  for(int i=0;i<lengthT+1;i++)
		  DP[0][i] = i;
//	  for (int i = 0; i < lengthS; i++) {
//		  for(int j = 0;j < lengthT; j++)
//		  {
//			  System.out.print(DP[i][j] + " ");
//		  }
//		System.out.println();
//	}
	  for (int i = 1; i < lengthS+1; i++) 
	  {
		  for(int j = 1;j < lengthT+1; j++)
		  {
			  int DPsame = Integer.MAX_VALUE, DPup,DPside;
			  if(sArr[i-1] == tArr[j-1])
				  DPsame = DP[i-1][j-1];
			  else if(sArr[i-1] != tArr[j-1]) {
				  DPsame = DP[i-1][j-1] + 1;
			  }
			  DPup = DP[i-1][j]+1;
			  DPside = DP[i][j-1]+1;
			  DP[i][j] = min(DPsame, DPside, DPup);
		  }
	  }
	  return DP[lengthS][lengthT];
  }
  private static int min(int a, int b, int c) {
	// TODO Auto-generated method stub
	  if(a<=b && a<=c)
  		return a;
  	else if(b<=a && b<=c)
  		return b;
  	else if(c<=a && c<=b)
  		return c;
	return 0;
}
public static void main(String args[]) {
    Scanner scan = new Scanner(System.in);

    String s = scan.next();
    String t = scan.next();

    System.out.println(EditDistance(s, t));
  }

}
