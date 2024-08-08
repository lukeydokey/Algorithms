import java.util.*;

class Solution {
    /*
    수포자 1 : 1 2 3 4 5 ...
    수포자 2 : 2 1 2 3 2 4 2 5 ...
    수포자 3 : 3 3 1 1 2 2 4 4 5 5 ...
    */
    public int[] solution(int[] answers) {
        int[] method1 = {1,2,3,4,5};
        int[] method2 = {2,1,2,3,2,4,2,5};
        int[] method3 = {3,3,1,1,2,2,4,4,5,5};
        
        int[] cnt = new int[3+1]; // 수포자 3명 맞춘 갯수 cnt
        int best = 0;
        for(int i=0;i<answers.length;i++){
            for(int j=1;j<=3;j++){
                if(j==1 && answers[i] == method1[i%5]){
                    cnt[j]++;
                }else if (j==2 && answers[i] == method2[i%8]){
                    cnt[j]++;
                }else if (j==3 && answers[i] == method3[i%10]){
                    cnt[j]++;
                }
                if(best<cnt[j]) best++;
            }
        }
        
        ArrayList<Integer>list = new ArrayList<>();
        for(int i=1;i<=3;i++){
            if(best==cnt[i]) list.add(i);
        }
        int[] answer = new int[list.size()];
        for(int i=0;i<answer.length;i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}