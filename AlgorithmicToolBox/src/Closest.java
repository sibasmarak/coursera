import java.io.*;
import java.util.*;


import static java.lang.Math.*;

public class Closest {
    private static Random random = new Random();
    //public static HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    public static Point[] map;
    static class Point implements Comparable<Point> {
        long x, y;

        public Point(long x, long y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o) {
            return o.y == y ? Long.signum(x - o.x) : Long.signum(y - o.y);
        }
        public double dist(Point e)
        {
        	return sqrt((e.x-this.x)*(e.x-this.x) + (e.y-this.y)*(e.y-this.y));
        }
        public static double dist(int x1, int x2, long y2, long y3)
        {
        	return sqrt((x2 - x1)*(x2 - x1) + (y3 - y2)*(y3 - y2));
        }
    }

    static double minimalDistance(int[] x, Point[] map,int l, int h) {
        double ans = Double.POSITIVE_INFINITY;
        //write your code here
        if(l>=h)
        	return ans;
        if(map == null)
        	return ans;
        if(map[1]!=null && map[0]!=null &&  h == l+1) {
        	//ystem.out.println(map[l] + " " +  map[h]);
        	return map[0].dist(map[1]);
        }
        	
        int mid = l + (h-l)/2,i,L=0,R=0;
        Point[] mapL = new Point[h-l+1];
        Point[] mapR = new Point[h-l+1];
        
        for(i=0;i<=h-l;i++)
        {
        	if(map[i]!=null && abs(map[i].x - x[mid]) <= 0)
			{
				//these sorted with y points from map
				//should be going to the left half
				mapL[L++] = map[i]; 
			}
			else
			{
				//these sorted with y points from map
				//should be going to the right half
				mapR[R++] = map[i];
			}
        }
        
        double d1 = minimalDistance(x, mapL, l, mid);
        double d2 = minimalDistance(x, mapR, mid+1, h);
        ans = min(d1, d2);
        //till now ans contains the minimum of the left half and the right half
        //now just remain the middle strip to be considered
        
        Point middleStrip[] = new Point[h-l+1];
        int M = 0; //index for middleStrip
        for(i=0;i<map.length;i++)
        {
        	if(map[i]!=null && abs(map[i].x - x[mid]) < ans)
			{
				//these sorted with respect to y points
				//are within the middle strip
				//thus they have to be added
				middleStrip[M++] = map[i];
			}
        }
        
        //now check for the middle strip
        //if the y-dist < d, then consider the total distance
        //	if the dist becomes smaller than ans then update ans
        //	else skip that pair
        for(i=0;i<middleStrip.length;i++)
        {
        	
        	for(int j=i+1;j<middleStrip.length && middleStrip[i]!=null && 
        			middleStrip[j]!=null && abs(middleStrip[j].y - middleStrip[i].y) < ans;j++)
        	{
        		if(middleStrip[j].dist(middleStrip[i]) < ans)
        			ans = middleStrip[j].dist(middleStrip[i]);
        	}
        }
        return ans;
    }

    public static void main(String[] args) throws Exception {
        reader = new BufferedReader(new InputStreamReader(System.in));
        writer = new PrintWriter(System.out);
        int n = nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        map = new Point[n];//created a map of points which contains for 
        //each corresponding x its corresponding y value
        for (int i = 0; i < n; i++) {
            x[i] = nextInt();
            y[i] = nextInt();
            Point p = new Point(x[i], y[i]);
            map[i] = p;
        }
        //map : contains the corresponding x and y coordinate
        randomizedQuickSort(x, 0, x.length-1);//got the sorted array of x points
        randomizedQuickSort(y, 0, y.length-1);//got the sorted array of y points
        //now create two arrays :
        //x which contains the sorted x coordinate since this is used to determine mid only
        //map which contains the points sorted w.r.t y coordinate
        
        //store in map the 
        sortY(map,0,n-1);
        System.out.printf("%.4f" , minimalDistance(x, map, 0, n-1));
        writer.close();
    }
    
    private static void sortY(Point[] map, int l, int r) {
		// TODO Auto-generated method stub
    	if (l >= r) {
            return;
        }
        int k = random.nextInt(r - l + 1) + l;
        Point t = map[l];
        map[l] = map[k];
        map[k] = t;
        //use partition3
        int m[] = partition3(map, l, r);
        sortY(map, l, m[0] - 1);
        sortY(map, m[1]+1, r);
    }
	private static int[] partition3(Point[] map, int l, int r) {
		// TODO Auto-generated method stub

        int m1 = l;Point pivot = map[l];Point temp;
        int high = r,m2=l;
        while(m2 <= high)
        {
      	  if(map[m2].compareTo(pivot) == 0)//same point
      		  m2++;
      	  else if(map[m2].compareTo(pivot) < 0)
      	  {
      		  temp = map[m1];
      		map[m1] = map[m2];
      		map[m2] = temp;
      		  m1++; m2++;
      	  }
      	  else if(map[m2].compareTo(pivot) > 0)
      	  {
      		  temp = map[high];
      		map[high] = map[m2];
      		map[m2] = temp;
      		  high--;
      	  }
        }
        
        int[] m = {m1, m2-1};
        return m;
	}
	

	private static int[] partition3(int[] a, int l, int r) {
        //write your code here


        int m1 = l, pivot = a[l];
        int high = r,m2=l;
        while(m2 <= high)
        {
      	  if(a[m2] == pivot)
      		  m2++;
      	  else if(a[m2] < pivot)
      	  {
      		  int temp = a[m1];
      		  a[m1] = a[m2];
      		  a[m2] = temp;
      		  m1++; m2++;
      	  }
      	  else if(a[m2] > pivot)
      	  {
      		  int temp = a[high];
      		  a[high] = a[m2];
      		  a[m2] = temp;
      		  high--;
      	  }
        }
        
        int[] m = {m1, m2-1};
        return m;
      }
    private static void randomizedQuickSort(int[] a, int l, int r) {
          if (l >= r) {
              return;
          }
          int k = random.nextInt(r - l + 1) + l;
          int t = a[l];
          a[l] = a[k];
          a[k] = t;
          //use partition3
          int m[] = partition3(a, l, r);
          randomizedQuickSort(a, l, m[0] - 1);
          randomizedQuickSort(a, m[1]+1, r);
      }

    static BufferedReader reader;
    static PrintWriter writer;
    static StringTokenizer tok = new StringTokenizer("");


    static String next() {
        while (!tok.hasMoreTokens()) {
            String w = null;
            try {
                w = reader.readLine();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (w == null)
                return null;
            tok = new StringTokenizer(w);
        }
        return tok.nextToken();
    }

    static int nextInt() {
        return Integer.parseInt(next());
    }
}
