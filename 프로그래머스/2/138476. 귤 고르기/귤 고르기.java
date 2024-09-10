import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> tanger = new HashMap<>();
        
        for(int i=0;i<tangerine.length;i++){
            if(!tanger.containsKey(tangerine[i])){
                tanger.put(tangerine[i], 1);
                continue;
            }
            tanger.replace(tangerine[i], tanger.get(tangerine[i]) + 1);
        }
        
        List<Integer> keySet = new ArrayList<>(tanger.keySet());
        keySet.sort((o1, o2) -> tanger.get(o2).compareTo(tanger.get(o1)));
        int answer = 0;
        
        for(int key : keySet){
            answer++;
            int size = tanger.get(key);
            if(k - size < 1) break;
            k -= size;
        }
        
        return answer;
    }
}