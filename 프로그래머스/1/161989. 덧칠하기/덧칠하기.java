import java.util.*;

class Solution {
    public int solution(int n, int m, int[] section) {
        List<Integer> sections = new ArrayList<>();
        for(int i=0;i<section.length;i++){
            sections.add(section[i]);
        }
        int answer = 0;
        while(!sections.isEmpty()){
            answer++;
            int cur = sections.get(0);
            while(!sections.isEmpty()&&sections.get(0)< cur+m){
                sections.remove(0);
            }
        }
        return answer;
    }
}