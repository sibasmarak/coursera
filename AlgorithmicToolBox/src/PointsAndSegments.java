import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;
class Hope
{
	int val;
	char type;
}
public class PointsAndSegments {
	private static Random random = new Random();

    private static int[] fastCountSegments(int[] starts, int[] ends, int[] points) {
        int[] cnt = new int[points.length];
        //create a HashSet of points to store their no. of segments 
        //adjacent to the point's value
        
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i : cnt) {
			map.put(i, 0);
		}
        
        Hope[] arr = new Hope[starts.length + points.length + ends.length];
        for (int i = 0; i < starts.length; i++) {
        	arr[i] = new Hope();
			arr[i].val = starts[i];
			arr[i].type = 's';
		}
        for (int i = 0; i < ends.length; i++) {
        	arr[i+starts.length] = new Hope();
			arr[i+starts.length].val = ends[i];
			arr[i+starts.length].type = 'e';
		}
        for (int i = 0; i < points.length; i++) {
        	arr[i+starts.length+ends.length] = new Hope();
			arr[i+starts.length+ends.length].val = points[i];
			arr[i+starts.length+ends.length].type = 'p';
		}
//        for (Hope hope : arr) {
//			System.out.println(hope.val + " " + hope.type);
//		}
        
        randomizedQuickSort(arr, 0, arr.length-1);
//    	System.out.println("\n");
//        for (Hope hope : arr) {
//			System.out.println(hope.val + " " + hope.type);
//		}
        
        int start = 0;
        for(int i=0;i<arr.length;i++)
        {
        	if(arr[i].type == 's')
        		start++;
        	else if(arr[i].type == 'e')
        		start--;
        	else if(arr[i].type == 'p')
        	{
        		//find the index for the arr[i].val
        		//use binarySearch to find
        		//later in main function, transfer the values to the other 
        		//array using O(nlogn) time complexity
        		map.put(arr[i].val, start);
        	}
        }
        //write your code here
        
        for (int i = 0;i<points.length;i++) {
			cnt[i] = map.get(points[i]);
        }
        return cnt;
    }

    private static void randomizedQuickSort(Hope[] a, int l, int r) {
		// TODO Auto-generated method stub
    	if (l >= r) {
            return;
        }
//    	System.out.println("\n");
//        for (Hope hope : a) {
//			System.out.println(hope.val + " " + hope.type);
//		}
        int k = random.nextInt(r - l + 1) + l;
        Hope t = a[l];
        a[l] = a[k];
        a[k] = t;
        //use partition3
        int m[] = partition3(a, l, r);
        randomizedQuickSort(a, l, m[0] - 1);
        randomizedQuickSort(a, m[1]+1, r);
    }
	

	private static int[] partition3(Hope[] a, int l, int r) {
		// TODO Auto-generated method stub
        int m1 = l;
		Hope pivot = a[l];
		//System.out.println("PIVOT: " + pivot.val + " " + pivot.type);
        int high = r,m2=l;
        while(m2 <= high)
        {
      	  if(a[m2].val == pivot.val) {
      			  m2++;
      	  }
      	  else if(a[m2].val < pivot.val)
      	  {
      		  Hope temp = a[m1];
      		  a[m1] = a[m2];
      		  a[m2] = temp;
    		  m1++; m2++;
      	  }
      	  else if(a[m2].val > pivot.val)
      	  {
      		  Hope temp = a[high];
      		  a[high] = a[m2];
      		  a[m2] = temp;
      		  high--;
      	  }
        }
        
        int[] m = {m1, m2-1};
        //now sort the sorted region, so that
        //the final ordering of the same value is
        //s,p,e
        sortTheSorted(a,m1,m2-1);
        return m;
	}

	private static void sortTheSorted(Hope[] a, int m1, int m2) {
		// TODO Auto-generated method stub
		//use counting sort simply rather than 
		//Dutch National Flag Algorithm
		int val = a[m1].val;
		int temp_0 = 0;//'e';
		int temp_1 = 0;//'p';
		int temp_2 = 0;//'s';
		for (int i=m1;i<=m2;i++) {
			Hope c = a[i];
			if(c.type == 'e')
				temp_0 += 1;
			else if(c.type == 'p')
				temp_1 += 1;
			else if(c.type == 's')
				temp_2 += 1;
		}
		//System.out.println(temp_0 + " "  +temp_1 + " " + temp_2) ;
		for (int i = m1; i < m1+temp_2; i++) {
			a[i].val = val;
			a[i].type = 's';
		}
		for (int i = m1+temp_2; i < m1+temp_2+temp_1; i++) {
			a[i].val = val;
			a[i].type = 'p';
		}
		for (int i = m1+temp_2+temp_1; i <= m2; i++) {
			a[i].val = val;
			a[i].type = 'e';
		}

	}

	private static int[] naiveCountSegments(int[] starts, int[] ends, int[] points) {
        int[] cnt = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < starts.length; j++) {
                if (starts[j] <= points[i] && points[i] <= ends[j]) {
                    cnt[i]++;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n, m,j=0;
        n = scanner.nextInt();
        m = scanner.nextInt();
        int[] starts = new int[n];
        int[] ends = new int[n];
        int[] points = new int[m];
        
        for (int i = 0; i < n; i++) {
            starts[i] = scanner.nextInt();
            ends[i] = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            points[i] = scanner.nextInt();
        }
        
        
        //use fastCountSegments
        int[] cnt = fastCountSegments(starts, ends, points);
        for (int x : cnt) {
            System.out.print(x + " ");
        }
    }
}