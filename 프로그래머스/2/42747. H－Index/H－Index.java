import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        for(int i=0;i<citations.length;i++){
            int cur = citations[i]; // 현재 논문 인용 횟수
            if(cur >= citations.length - i){
                answer = citations.length - i;
                break;
            } 
        }
        
        return answer;
    }
}