import java.util.*;
import java.io.*;

public class CarFueling {
    static int computeMinRefills(int dist, int tank, int[] stops) {
    	int minRefills = 0;
    	if(stops.length == 1)
    	{
    		if(dist<=tank)
    			return 0;
    		else 
    		{
    			if(dist - stops[0] > 0)
    				return -1;
    			else
    				return 1;
    		}
    	}
    	int distTravelled=0;
    	for(int i=0; i<stops.length ;i++)
    	{
    		if(stops[i] - distTravelled > tank)
    		{
    			distTravelled = stops[i-1];
    			minRefills++;
    		}
    		else if(stops[i] - distTravelled == tank)
    		{
    			distTravelled = stops[i];
    			minRefills++;
    		}
    	}
    	int remCapacity  = tank - (stops[stops.length-1]-distTravelled);
    	if(remCapacity<=dist-stops[stops.length-1])
    	{
    		if(remCapacity < 0)
    			return -1;
    		if(dist-stops[stops.length-1]<=tank)
    				return ++minRefills;
    		return -1;
    	}
		return minRefills;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dist = scanner.nextInt();
        int tank = scanner.nextInt();
        int n = scanner.nextInt();
        int stops[] = new int[n];
        for (int i = 0; i < n; i++) {
            stops[i] = scanner.nextInt();
        }

        System.out.println(computeMinRefills(dist, tank, stops));
    }
}
