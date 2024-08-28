import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String, Integer> id_map = new HashMap<>();
        for(int i=0;i<id_list.length;i++){
            id_map.put(id_list[i], i);
        }
        Set<String>[] report_set = new HashSet[id_list.length];
        Set<String>[] reported_set = new HashSet[id_list.length];
        for(int i=0;i<id_list.length;i++){
            report_set[i] = new HashSet<String>();
            reported_set[i] = new HashSet<String>();
        }
        for(int i=0;i<report.length;i++){
            String[] tmp = report[i].split(" ");
            report_set[id_map.get(tmp[0])].add(tmp[1]);
            reported_set[id_map.get(tmp[1])].add(tmp[0]);
        }
        int[] answer = new int[id_list.length];
        for(int i=0;i<id_list.length;i++){
            for(String reported : report_set[i]){
                if(reported_set[id_map.get(reported)].size()>=k)answer[i]++;
            }
        }
        return answer;
    }
}