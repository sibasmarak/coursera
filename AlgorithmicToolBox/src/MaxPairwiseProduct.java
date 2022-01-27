import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class MaxPairwiseProduct {
    static BigInteger getMaxPairwiseProduct(BigInteger[] numbers) {
        int maxIndex = 0;
        int maxIndex2 = 0;
        BigInteger max_value = new BigInteger("-1");
        BigInteger max_value2 = new BigInteger("-1");
        int index;

        for(index = 0;index < numbers.length;index++)
        {
        	if(numbers[index].compareTo(max_value)==1)
        	{
        		maxIndex = index;
        		max_value = new BigInteger(numbers[index]+"");
        	}
        }
        for(index = 0;index<numbers.length;index++)
        {
        	if(numbers[index].compareTo(max_value2)==1 && index!=maxIndex)
        	{
        		maxIndex2 = index;
        		max_value2 = new BigInteger(numbers[index] + "");
        	}
        }
        return (numbers[maxIndex]).multiply(numbers[maxIndex2]);
        }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        BigInteger[] numbers = new BigInteger[n];
        int index;
        for (index = 0;index<n;index++) {
            numbers[index] = new BigInteger(""+scanner.nextInt());
        }
        System.out.println(getMaxPairwiseProduct(numbers));
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new
                    InputStreamReader(stream));
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