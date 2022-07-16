package src.array3;

import java.util.ArrayList;
import java.util.List;

public class MajorityElement2 {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        int cand1 = -1, cand2 = -1;
        int count1 = 0, count2 = 0;
        
        for(int i = 0; i<n; i++) {
            if(cand1 == nums[i]) ++count1;
            else if(cand2 == nums[i]) ++count2;
            else if(count1 == 0) {
                cand1 = nums[i];
                ++count1;
            } else if(count2 == 0) {
                cand2 = nums[i];
                ++count2;
            } else {
                --count1; 
                --count2;
            }
        }
        
        count1 = count2 = 0;
        for(int i = 0; i<n; i++) {
            if(nums[i] == cand1) ++count1;
            if(nums[i] == cand2) ++count2;
        }
        
        List<Integer> result = new ArrayList<>();
        if(count1 > n/3) result.add(cand1);
        if(count2 > n/3 && cand1 != cand2) result.add(cand2);
        
        return result;
    }
}
