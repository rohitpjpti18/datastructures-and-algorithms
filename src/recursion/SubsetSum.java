package src.recursion;

import java.util.ArrayList;
import java.util.List;

public class SubsetSum {
    List<List<Integer>> result = new ArrayList<>();
    
    public void recursive(int[] nums, List<Integer> output, int i) {
        if(i == nums.length) {
            result.add(new ArrayList<>(output));
            return;
        }
        
        output.add(nums[i]);
        recursive(nums, output, i+1);
        output.remove(output.size()-1);
        recursive(nums, output, i+1);
    }
    
    public List<List<Integer>> subsets(int[] nums) {
        recursive(nums, new ArrayList<Integer>(), 0);
        return result;
    }
}
