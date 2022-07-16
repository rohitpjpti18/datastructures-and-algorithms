package src.recursion;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public boolean isPalindrome(String s, int start, int end) {
        while(start <= end) {
            if(s.charAt(start) != s.charAt(end)) return false;
            start++; end--;
        }
        
        return true;
    }
    
    public void recursive(String s, int index, List<String> output, List<List<String>> result){
        if(index == s.length()) {
            result.add(new ArrayList<>(output));
            return; 
        }
        
        for(int i = index; i<s.length(); ++i) {
            if(isPalindrome(s, index, i)) {
                output.add(s.substring(index, i+1));
                recursive(s, i+1, output, result);
                output.remove(output.size()-1);
            }
        }
    } 
    
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        
        recursive(s, 0, new ArrayList<>(), result);
        return result;
    }
}
