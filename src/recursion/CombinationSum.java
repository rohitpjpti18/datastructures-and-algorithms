package src.recursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public void recursive(int[] candidates, int index, int target, List<Integer> output, List<List<Integer>> result) {
        if(candidates.length == index) {
            if(target == 0) result.add(new ArrayList<>(output));
            return;
        }
        
        if(candidates[index] <= target) {
            output.add(candidates[index]);
            recursive(candidates, index, target - candidates[index], output, result);
            output.remove(output.size() - 1);
        }
        recursive(candidates, index+1, target, output, result);
    }
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        recursive(candidates, 0, target, new ArrayList<>(), result);
        return result;
    }
}
