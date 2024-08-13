class Solution {
    public int solution(String[] babbling) {
        String[] pronun = {"aya", "ye", "woo", "ma"};
        String[] wrong = {"ayaaya", "yeye", "woowoo", "mama"};
        int answer = 0;
        for(int i=0;i<babbling.length;i++){
            boolean flag = false;
            for(int j=0;j<4;j++){
                if(babbling[i].contains(wrong[j])) flag = true;
            }
            if(flag)continue;
            
            for(int j=0;j<4;j++){
                babbling[i] = babbling[i].replaceAll(pronun[j]," ");
            }
            
            babbling[i] = babbling[i].replaceAll(" ", "");
            
            if(babbling[i].length()==0) answer++;
        }
        
        return answer;
    }
}