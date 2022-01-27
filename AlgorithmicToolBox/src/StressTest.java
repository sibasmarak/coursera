import java.util.*;
class Segment {
	long start, end;

    Segment(long start, long end) {
        this.start = start;
        this.end = end;
    }
}

public class StressTest{

    private static void optimalPoints(Segment[] segments) {
    	int lastIndex =0;
        Segment[] commonSegments = new Segment[segments.length+1];
        commonSegments[lastIndex] = new Segment(segments[0].start, segments[0].end);
        int i;
        for(i=0;i<segments.length;i++)
        {
        	int flag=0;
        	long start = segments[i].start;
        	long end = segments[i].end;
        	for(int j=0;j<=lastIndex;j++)
        	{
        		long startCom = commonSegments[j].start;
        		long endCom = commonSegments[j].end;
        		if(startCom < endCom) {
        		if(start >= startCom && start <= endCom)
        		{
        			commonSegments[j].start = (startCom>start)?startCom:start;
        			commonSegments[j].end = (endCom<end)?endCom:end;
        			flag = 1;
        		}
        		else if(end >= startCom && end <= endCom)
        		{
        			commonSegments[j].start = (startCom>start)?startCom:start;
        			commonSegments[j].end = (endCom<end)?endCom:end;
        			flag = 1;
        		}
        		}
        		else
        		{
        			if(start <= startCom && start >= endCom)
            		{
            			commonSegments[j].start = (startCom>start)?startCom:start;
            			commonSegments[j].end = (endCom<end)?endCom:end;
            			flag = 1;
            		}
            		else if(end <= startCom && end >= endCom)
            		{
            			commonSegments[j].start = (startCom>start)?startCom:start;
            			commonSegments[j].end = (endCom<end)?endCom:end;
            			flag = 1;
            		}
        		}
        	}
        	if(flag==0)
        		commonSegments[++lastIndex] = new Segment(start, end);
        	flag = 0;
        }
        System.out.println(lastIndex+1);
        long arr1[] = new long[lastIndex+1];
        for (int j = 0; j<=lastIndex ; j++) 
        {
        	arr1[j] = commonSegments[j].start;
		}
        Arrays.sort(arr1);
        for (long l : arr1) {
			System.out.print(l + " ");
		}
        return;
        
    }
	
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = 10;
        Random random = new Random();
        Segment[] segments = new Segment[n];
        for (int i = 0; i < n; i++) {
        	long start, end;
            start = random.nextInt(100);
            end = random.nextInt(100);
            System.out.println(start +  " " + end);
            System.out.println();
            segments[i] = new Segment(start, end);
        }
       
        optimalPoints(segments);
    }
}

 
