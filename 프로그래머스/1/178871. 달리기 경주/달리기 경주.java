import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> pMap = new HashMap<>();
        for(int i=0;i<players.length;i++){
            pMap.put(players[i], i);
        }
        
        for(int i=0;i<callings.length;i++){
            swap(players, pMap, callings[i]);
        }
        
        return players;
    }
    public void swap (String[] players, Map<String, Integer> pMap, String player){
        int index = pMap.get(player);
        String tmp = players[index-1];
        players[index-1] = player;
        players[index] = tmp;
        pMap.put(player, index-1);
        pMap.put(tmp, index);
    }
}