import java.util.Scanner;

public class FractionalKnapsack {
    private static double getOptimalValue(int capacity, int[] values, int[] weights) {
        double value = 0;
        int maxIndex;
        for(int i=0;i<values.length;i++)
        {
        	double max = (double)values[i]/(double)weights[i];
        	maxIndex = i;
        	for(int j=i+1;j<values.length;j++)
        	{
        		double temp = (double)values[j]/(double)weights[j];
        		if(temp > max)
        		{
        			maxIndex = j;
        			max = temp;
        		}
        	}
        	if(capacity>0)
        	{
        		if(weights[maxIndex]<=capacity)
        		{
        			double tempVal = max*(double)weights[maxIndex];
        			value += tempVal;
        			capacity -= weights[maxIndex];
        		}
        		else
        		{
        			double tempVal = max*(double)capacity;
        			value += tempVal;
        			capacity -= capacity;
        		}
        	}
        	else
        		break;
        	
        	int V = values[i];
        	values[i] = values[maxIndex];
        	values[maxIndex] = V;
        	V = weights[i];
        	weights[i] = weights[maxIndex];
        	weights[maxIndex] = V;
        }
        
        return value;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        System.out.printf("%.4f", getOptimalValue(capacity, values, weights));
    }
} 
