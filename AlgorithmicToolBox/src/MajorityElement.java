import java.util.*;
import java.io.*;


public class MajorityElement {
    private static int getMajorityElement(int[] a, int left, int right) {
        if (left == right) {
            return -1;
        }
        if (left + 1 == right) {
            if(a[left] == a[right])
            	return a[left];
            else
            	return -1;
        }
        int szOfArr = (right-left+1);
        int middle = left + (right-left)/2;
        int majorityInLeft = getMajorityElement(a, left, middle);
        int majorityInRight = getMajorityElement(a, middle+1, right);
        if(majorityInLeft == majorityInRight)
        	return majorityInLeft;
        else if(majorityInLeft == -1 && majorityInRight!=-1)
        {
        	//check if the majority in right is greater than half of the szOfArr
        	//if true then return majorityInRight as the majority for this segment
        	//else return -1
        	int count = 0;
        	for (int i = left; i < right+1; i++) {
				if(a[i] == majorityInRight)
					count++;
			}
        	if(2*count > szOfArr)
        		return majorityInRight;
        	else 
        		return -1;
        	
        }
        else if(majorityInRight == -1 && majorityInLeft != -1)
        {
        	//check if the majority in left is greater than half of the szOfArr
        	//if true then return majorityInLeft as the majority for this segment
        	//else return -1
        	int count = 0;
        	for (int i = left; i < right+1; i++) {
				if(a[i] == majorityInLeft)
					count++;
			}
        	if(2*count > szOfArr)
        		return majorityInLeft;
        	
        }
        else
        {
        	//one more case when both majorityInLeft and majorityInRight
            //returns different values - check for the both which is majority
            //if any one of them is majority then return that
            //else return -1
        	int countL = 0;
        	for (int i = left; i < right+1; i++) {
				if(a[i] == majorityInLeft)
					countL++;
			}
        	if(2*countL > szOfArr)
        		return majorityInLeft;
        	
        	else
        	{
        		int countR = 0;
            	for (int i = left; i < right+1; i++) {
    				if(a[i] == majorityInRight)
    					countR++;
    			}
            	if(2*countR > szOfArr)
            		return majorityInRight;
        	}
        }
        return -1;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        if (getMajorityElement(a, 0, a.length-1) != -1) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}

