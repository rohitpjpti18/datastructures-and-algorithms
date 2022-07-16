package src.greedy;

import java.util.Arrays;

public class JobSchedule {
    public static int jobScheduling(int[][] jobs) {
        Arrays.sort(jobs, (a, b) -> -1*Integer.compare(a[1], b[1]));
        
        int maximum = Integer.MIN_VALUE;
        for(int i = 0; i<jobs.length; i++) maximum = Math.max(maximum, jobs[i][0]);
        
        int[] days = new int[maximum+1];
        for(int i = 0; i<days.length; i++) days[i] = -1;
        int profit = 0;
        for(int i = 0; i<jobs.length; i++) {
            for(int j = jobs[i][0]; j>0; --j) {
                if(days[j] == -1) {
                    days[j] = i;
                    profit += jobs[i][1];
                    break;
                } 
            }
        }
        
        return profit;
    }
}
