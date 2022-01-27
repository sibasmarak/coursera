import java.util.*;

public class Inversions {

    private static long getNumberOfInversions(int[] a, int[] b, int left, int right) {
        long numberOfInversions = 0;
        
        if(left < right)
        {
        	int mid = left + (right - left)/2;
        	numberOfInversions += getNumberOfInversions(a, b, left, mid);
        	numberOfInversions += getNumberOfInversions(a, b, mid+1, right);
        	numberOfInversions += merge(a, b, left,right);
        }
        //System.out.println("Number of inversions: " + numberOfInversions);
        return numberOfInversions;
    }

    private static long merge(int[] a, int[] b, int left, int right) {
		// TODO Auto-generated method stub
    	int mid = left + (right - left)/2;
    	int i = left, j = mid+1, count = 0,k=left;
    	while(i<=mid && j<=right)
    	{
    		if(a[i] < a[j])
    		{
    			b[k++] = a[i++];
    		}
    		else if(a[i] > a[j])
    		{
    			int tempI = i;
    			while(tempI <= mid && a[tempI] > a[j])
    			{
    				count++;
    				tempI++;
    			}
    			b[k++] = a[j++];
    		}
    		else if(a[i] == a[j])
    		{
    			b[k++] = a[i++];
    		}
    	}
    	while(i<=mid)
    	{
    		b[k++] = a[i++];
    	}
    	while(j <= right)
    	{
    		b[k++] = a[j++];
    	}
    	for (int k2 = left; k2 < k; k2++) {
			a[k2] = b[k2];
		}
    	
//    	System.out.println("b: ");
//    	for (int i1 : b) {
//			System.out.print(i1 + "\t");
//		}
//        System.out.println("\na: ");
//        for (int i1 : a) {
//			System.out.print(i1 + "\t");
//		}
    	return count;
	}

	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int[] b = new int[n];
        System.out.println(getNumberOfInversions(a, b, 0, a.length-1));
    }
}

