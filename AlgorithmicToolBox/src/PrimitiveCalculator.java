import java.util.*;

public class PrimitiveCalculator {
	static int DP[];
    private static Set<Integer> optimal_sequence(int n) {
    	Set<Integer> sequence = new TreeSet<Integer>();
    	
    	//int arr to store the minimum #operation required
    	//to do using the given calculator
    	DP = new int[n+1];
    	//since zero operation required for calculating 0
    	//since 1 operation required for calculating 1
    	//since 2 operation required for calculating 2
    	
    	if(n==2) {
    		sequence.add(1);
    		sequence.add(2);
    		return sequence;
    	}
    	if(n==1)
    	{
    		sequence.add(1);
    		return sequence;
    	}
    	else
    	{
    		DP[0] = 0; DP[1] = 0;
    		int by_2,by_3,minus_1;
    		sequence.add(0);
    		for(int i = 2;i<n+1;i++)
    		{
    			minus_1 = i-1;
    			int valForMinus1 = DP[minus_1] + 1;
    			int valForDivBy2 =  Integer.MAX_VALUE,
    					valForDivBy3 = Integer.MAX_VALUE;
    			if(i%2 == 0) {
        			by_2 = i/2;
        			valForDivBy2 = DP[by_2] + 1;
    			}
    			if(i%3 == 0) {
    				by_3 = i/3;
    				valForDivBy3 = DP[by_3] + 1;
    			}
    			
    			DP[i] = min(valForMinus1,valForDivBy2,valForDivBy3);
    			int min = DP[i];
//    			System.out.println(i + " " + valForDivBy2 +
//    					" "  +valForDivBy3 +" " + valForMinus1);
//    			
    			if(min == valForMinus1)
    			{
    				//System.out.println("true_if");
    				//this means just by adding 1 we are fine
    				sequence.add(minus_1);
    			}
    			else if(min == valForDivBy2)
    			{
    				//this means i was achieved in a minimum way 
    				//by dividing 2
    				//System.out.println("true_elseif1");
    				sequence.add(i/2);
    			}
    			else if(min == valForDivBy3)
    			{
    				//System.out.println("true_elseif2");
    				//this means i was achieved in a minimum way 
    				//by dividing 3
    				sequence.add(i/3);
    			}
    		}
    		
    	}    	
        return sequence;
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

	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Set<Integer> sequence = optimal_sequence(n);
        List<Integer> Psequence = new ArrayList<Integer>();
//        for (Integer integer : sequence) {
//			System.out.print(integer + "\t");
//		}
//        System.out.println();
        System.out.println(DP[n]);
        int getByIndex = n-1;
        Psequence.add(n);
        while(getByIndex>0)
        {
        	//System.out.println(getByIndex);
        	//Psequence.add(sequence.get(getByIndex));
        	//getByIndex = sequence.get(getByIndex)-1;
        }
        sequence.clear();
        Collections.reverse(Psequence);
        for (Integer integer : Psequence) {
			System.out.print(integer + " ");
		}
    }
}

