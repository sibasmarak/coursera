import java.util.*;

public class LargestNumber {
    private static String largestNumber(String[] a) {
    	Arrays.sort(a);
    	int k=0;
        for(int i = 0; i<a.length;i++)
        {
        	k=i;
        	String max = a[i];
        	for(int j=i+1;j<a.length;j++) 
        	{
        		if(isGreaterOrEqual(a[j],max))
        		{
        			k = j;
        			max = a[j];
        		}
        	}
        	String temp = a[k];
        	a[k] = a[i];
        	a[i] = temp;
        }
        String result = "";
        for (int i = 0; i < a.length; i++) {
            result += a[i];
        }
        return result;
    }

	private static boolean isGreaterOrEqual(String string, String string2) 
	{
		int newString = Integer.parseInt(string + string2);
		int newString2 = Integer.parseInt(string2 + string);
		if(newString > newString2)
			return true;
		else if(newString < newString2)
			return false;
		else
		{
			return (string.length()>= string2.length())?false:true;
		}
	}

	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] a = new String[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.next();
        }
        System.out.println(largestNumber(a));
    }
}

