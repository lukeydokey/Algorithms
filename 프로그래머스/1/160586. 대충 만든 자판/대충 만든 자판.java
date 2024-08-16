class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        
        for(int i=0;i<targets.length;i++){
            String target = targets[i];
            int cnt = 0; // 키 누른 횟수 카운트
            for(int j=0;j<target.length();j++){
                String t = target.charAt(j)+"";
                int min = 0; // 키를 누르는 최소 횟수
                for(int k=0;k<keymap.length;k++){
                    if(!keymap[k].contains(t))continue;
                    if(min == 0) min = keymap[k].indexOf(t)+1;
                    else min = Math.min(min, keymap[k].indexOf(t)+1);
                }
                if(min == 0) {
                    cnt = -1;
                    break;
                }
                cnt += min;
            }
            answer[i] = cnt;
        }
        
        return answer;
    }
}