package datastructures;

import java.util.Stack;

public class StackQuestions {
    private static Stack<Character> stack;

    public static boolean validParentheses(String s){
        
        for(Character i: s.toCharArray()){
            if(i == '('){
                stack.push(i);
            }else if(i == ')'){
                if(stack.empty()){
                    return false;
                }
                if(stack.peek() == '('){
                    stack.pop();
                    continue;
                }else{
                    return false;
                }
            }
        }

        if(!stack.empty()){
            return false;
        }

        return true;
    }

    public static void main(String[] args){
        stack = new Stack<Character>();

        System.out.println(validParentheses("()("));
    }
}
