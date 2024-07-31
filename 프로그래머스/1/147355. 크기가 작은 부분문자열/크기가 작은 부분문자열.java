import java.util.*;

class Solution {
    public int solution(String t, String p) {
        ArrayList<String> subStr = new ArrayList<>();
        for(int i=0;i<t.length()-(p.length()-1);i++){
            subStr.add(t.substring(i,i+p.length())); // p와 길이가 같은 부분문자열 추가
        }
        Long pVal = Long.parseLong(p);
        int answer = 0;
        for(String sub : subStr){
            Long subVal = Long.parseLong(sub);
            if(subVal <= pVal) answer++;
        }
        
        return answer;
    }
}