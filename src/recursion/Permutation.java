package src.recursion;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
    public void recursive(int[] nums, int index, List<Integer> output, List<List<Integer>> result, boolean[] used) {
        if(output.size() == nums.length) {
            result.add(new ArrayList<>(output));
            return;
        }
        
        for(int i = 0; i < nums.length; i++) { 
            if(!used[i]) {
                output.add(nums[i]);
                used[i] = true;
                recursive(nums, i, output, result, used);
                used[i] = false;
                output.remove(output.size() - 1);      
            }

        }
    }
    
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        
        recursive(nums, 0, new ArrayList<>(), result, new boolean[nums.length]);
        return result;
    }
}
