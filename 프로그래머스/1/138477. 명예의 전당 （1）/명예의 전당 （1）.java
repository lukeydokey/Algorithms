import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        
        Queue<Integer> pq = new PriorityQueue<>();
        int[] answer = new int[score.length];
        
        for(int i=0;i<score.length;i++){
            if(pq.size()<k){
                pq.add(score[i]);
                int lowest = pq.poll();
                answer[i] = lowest;
                pq.add(lowest);
            }else {
                int lowest = pq.poll();
                if(score[i]<=lowest){
                    answer[i] = lowest;
                    pq.add(lowest);
                }else {
                    pq.add(score[i]);
                    int nLowest = pq.poll();
                    answer[i] = nLowest;
                    pq.add(nLowest);
                }
            }
        }
        return answer;
    }
}