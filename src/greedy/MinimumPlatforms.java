package src.greedy;

import java.util.Arrays;

public class MinimumPlatforms {
    public static int calculateMinPatforms(int start[], int end[], int n) {
        Arrays.sort(start);
        Arrays.sort(end);
        
        int s, e, result, current;
        s = e = result = current = 0;

        while(s < start.length && e < end.length) {
            if(start[s] <= end[e]) {
                current++;
                s++;
            } else {
                current--;
                e++;
            }
            result = Math.max(result, current);
        }
        
        return result;
    }
}
