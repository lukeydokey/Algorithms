import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int[] validate = new int[26];
        for(int i=0;i<terms.length;i++){
            validate[(int)(terms[i].charAt(0)-'A')] = Integer.parseInt(terms[i].split(" ")[1]);
        }
        String[] tmp = today.split("\\.");
        int todayY = Integer.parseInt(tmp[0]);
        int todayM = Integer.parseInt(tmp[1]);
        int todayD = Integer.parseInt(tmp[2]);
        
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<privacies.length;i++){
            tmp = privacies[i].substring(0,10).split("\\.");
            int privacyY = Integer.parseInt(tmp[0]);
            int privacyM = Integer.parseInt(tmp[1]);
            int privacyD = Integer.parseInt(tmp[2]);
            
            int validateM = validate[(int)(privacies[i].charAt(11)-'A')];
            if(privacyM + validateM <=12){
                privacyM += validateM;
            }else{
                privacyY += (privacyM + validateM) / 12;
                privacyM = (privacyM + validateM) % 12;
                if(privacyM==0){
                    privacyY--;
                    privacyM = 12;
                }
            }
            if(privacyD==1){
                privacyD=28;
                privacyM--;
                if(privacyM==0){
                    privacyM=12;
                    privacyY--;
                }
            }else{
                privacyD--;
            }
            int t = todayY * 10000 + todayM * 100 + todayD;
            int p = privacyY * 10000 + privacyM * 100 + privacyD;
            if(p<t) list.add(i+1);
        }
        
        int[] answer = new int[list.size()];
        for(int i=0;i<list.size();i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}