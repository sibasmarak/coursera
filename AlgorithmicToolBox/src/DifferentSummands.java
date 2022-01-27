import java.util.*;

public class DifferentSummands {
    private static List<Integer> optimalSummands(int n) {
        List<Integer> summands = new ArrayList<Integer>();
        int remaining = n, lastGiven = 0;
        while(remaining>0)
        {
        	int newLastGiven = lastGiven+1;
        	int newRemaining = remaining-newLastGiven;
        	if(newRemaining > newLastGiven)
        	{
        		summands.add(newLastGiven);
        		lastGiven = newLastGiven;
        		remaining = newRemaining;
        	}
        	else
        	{
        		break;
        	}
        }
        summands.add(remaining);
        return summands;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> summands = optimalSummands(n);
        System.out.println(summands.size());
        for (Integer summand : summands) {
            System.out.print(summand + " ");
        }
    }
}

