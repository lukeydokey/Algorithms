import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int t=0;t<commands.length;t++){ // commands의 길이만큼 명령 반복
            int[] tmp = new int[commands[t][1]-commands[t][0]+1]; // ex 2~5 == 5-2+1
            for(int i=0;i<tmp.length;i++){
                tmp[i] = array[commands[t][0]-1+i];
            }
            Arrays.sort(tmp);
            answer[t] = tmp[commands[t][2]-1];
        }
        return answer;
    }
}