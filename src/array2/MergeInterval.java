package src.array2;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeInterval {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b)-> Integer.compare(a[0], b[0]));
        ArrayList<int[]> result = new ArrayList<>();
        
        for(int[] i: intervals){
            if(result.isEmpty() || result.get(result.size() - 1)[1] < i[0]) result.add(i);
            else result.get(result.size() - 1)[1] = Math.max(result.get(result.size()-1)[1], i[1]);
        }
        
        return result.toArray(new int[result.size()][]);
    }
}
