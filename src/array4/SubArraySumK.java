package src.array4;

import java.util.HashMap;
import java.util.Map;

public class SubArraySumK {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> mpp = new HashMap<>();
        int count = 0;
        int sum = 0;
        
        mpp.put(0, 1);
        
        for(Integer i = 0; i<nums.length; ++i) {
            sum += nums[i];
            
            if(mpp.containsKey(sum-k)) 
                count += mpp.get(sum-k);
            mpp.put(sum, mpp.getOrDefault(sum, 0) + 1);
        }
        
        return count;
    }
}
