package leetcode.medium.stack;

import java.util.*;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

 The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.


 */
public class ValidParentheses {
    public boolean isValid(String s) {
        if(s.length() % 2 == 1) return false;
        Stack<Character> stack = new Stack<Character>();
        int i = 0;
        while(i < s.length()) {
            if(stack.isEmpty() || shouldPush(s.charAt(i))) {
                stack.push(s.charAt(i));
            } else if(!shouldPush(s.charAt(i)) && !stack.isEmpty() && check(s.charAt(i), stack.peek())) {
                stack.pop();
            } else {
                return false;
            }
            i ++;
        }
        if(stack.isEmpty()) return true;
        return false;
    }

    private boolean shouldPush(char c) {
        return (c == '(' || c == '[' || c == '{');
    }

    private boolean check(char c, char top) {
        return (c == ')' && top == '(' || c == ']' && top == '[' || c == '}' && top == '{');
    }
}
