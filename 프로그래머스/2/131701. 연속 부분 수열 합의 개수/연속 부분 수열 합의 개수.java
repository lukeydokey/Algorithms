import java.util.*;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> sumSet = new HashSet<>();
        
        for(int length=1;length<=elements.length;length++){
            int sum = 0;
            
            // 첫번째
            for(int i=0;i<length;i++){
                sum += elements[i];
            }
            sumSet.add(sum);
            
            for(int start = 1; start < elements.length; start++){
                sum -= elements[start - 1]; // 한칸씩 이동하며 앞 원소 제거
                sum += elements[((start - 1) + length) % elements.length];
                sumSet.add(sum);
            }
        }
        
        return sumSet.size();
    }
}