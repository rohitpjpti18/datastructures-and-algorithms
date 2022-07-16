package src.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetSum2 {
    public void recursive(int[] nums, int index, List<Integer> output, List<List<Integer>> result) {
        result.add(new ArrayList<>(output));
 
        for(int i = index; i<nums.length; i++) {
            if(i != index && nums[i] == nums[i-1]) continue;
            
            output.add(nums[i]);
            recursive(nums, i+1, output, result);
            output.remove(output.size() - 1);
        }
    }
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        recursive(nums, 0, new ArrayList<>(), result);
        
        return result;
    }
}
