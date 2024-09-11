import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        for(int i=0;i<s.length();i++){
            if(isRight(s)) answer++;
            s = s.substring(1) + s.charAt(0);
        }
        
        return answer;
    }
    public boolean isRight(String str){
        Stack<String> stack = new Stack<>();
        String[] s = str.split("");
        for(int i=0;i<str.length();i++){
            if(stack.isEmpty()) stack.push(s[i]);
            else if((stack.peek().equals("(") && s[i].equals(")")) 
                    || (stack.peek().equals("{") && s[i].equals("}"))
                    || (stack.peek().equals("[") && s[i].equals("]")))
                stack.pop();
            else
                stack.push(s[i]);
        }
        if(stack.isEmpty())
            return true;
        else
            return false;
    }
}