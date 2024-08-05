class Solution {
    public int[] solution(String s) {
        
        int[] answer = new int[s.length()];
        int[] alpha = new int[26]; // 알파벳 위치
        for(int i=0;i<26;i++){
            alpha[i] = -1;
        }
        for(int i=0;i<s.length();i++){
            int cur = (int)s.charAt(i)-'a'; // 현재 알파벳
            if(alpha[cur]==-1){ // 처음 나온 알파벳
                answer[i] = -1;
                alpha[cur] = i;
            }else {
                answer[i] = i - alpha[cur];
                alpha[cur] = i;
            }
        }
        
        return answer;
    }
}