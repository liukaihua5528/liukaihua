package cn.tedu.algorithm.stack;

import java.util.Stack;

/**
 * 判断括号是否匹配
 * @Date 2020/7/9 20:46
 * @Created by liukaihua
 */
public class IsValid {

    /**
     * 判断括号是否匹配
     * @param s
     * @return
     */
    public boolean isValid(String s){
        Stack<Character> stack = new Stack<>();
        for (int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }else {
                if (stack.isEmpty()) {
                    return false;
                }
                char topChar = stack.pop();
                if (c == ')' && topChar != '(') {
                    return false;
                }
                if (c == '}' && topChar != '{') {
                    return false;
                }
                if (c == ']' && topChar != '[') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(new IsValid().isValid("()[]{}"));
    }

}
