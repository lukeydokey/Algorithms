package programmers.p12930;

public class Solution {
    public String solution(String s){

        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) ==' ') {
                cnt = 0;
                sb.append(" ");
                continue;
            }
            sb.append(cnt % 2 == 0 ? s.substring(i,i+1).toUpperCase():s.substring(i,i+1).toLowerCase());
            cnt++;
        }
        return sb.toString();
    }
}
