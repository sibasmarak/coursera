import java.util.*;

public class CoveringSegments {

    private static void optimalPoints(Segment[] segments) {
    	int lastIndex =0;
    	for(int i = 0; i<segments.length;i++)
    	{
    		for(int j =i+1;j<segments.length;j++)
    		{
    			if(segments[i].start > segments[j].start)
    			{
    				Segment temp = segments[i];
    				segments[i] = segments[j];
    				segments[j] = temp; 
    			}
    		}
    	}
    	
        Segment[] commonSegments = new Segment[segments.length+1];
        commonSegments[lastIndex] = new Segment(segments[0].start, segments[0].end);

        int i;
        for(i=0;i<segments.length;i++)
        {
        	int flag=0;
        	long start = MIN(segments[i].start, segments[i].end);
        	long end = MAX(segments[i].end, segments[i].start);
        	if(start>= commonSegments[lastIndex].start && start<= commonSegments[lastIndex].end)
        	{
        		commonSegments[lastIndex].start = MAX(start,commonSegments[lastIndex].start);
        		commonSegments[lastIndex].end = MIN(end, commonSegments[lastIndex].end);
        		flag = 1;
        		
        	}
        	
        	if(flag==0)
        		commonSegments[++lastIndex] = new Segment(start, end);
        	flag = 0;
        }
        
        System.out.println(lastIndex+1);
        long arr1[] = new long[lastIndex+1];
        for (int j = 0; j<=lastIndex ; j++) 
        {
        	arr1[j] = commonSegments[j].end;
		}
        Arrays.sort(arr1);
        for (long l : arr1) {
			System.out.print(l + " ");
		}
        return;
    }
	private static long MAX(long end, long start) {
		return (end>start)? end: start;
	}
	private static long MIN(long start, long end) {
		return (end>start)?start:end;
	}
	private static class Segment {
		long start, end;

        Segment(long start, long end) {
            this.start = start;
            this.end = end;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Segment[] segments = new Segment[n];
        for (int i = 0; i < n; i++) {
        	long start, end;
            start = scanner.nextLong();
            end = scanner.nextLong();
            long start1 = MIN(start,end);
            long end1 = MAX(start,end);
            segments[i] = new Segment(start1, end1);
        }
       
        optimalPoints(segments);
    }
}

 
