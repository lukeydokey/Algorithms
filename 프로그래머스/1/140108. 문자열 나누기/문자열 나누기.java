class Solution {
    public int solution(String s) {
        int xCnt = 0;
        int notXCnt = 0;
        int answer = 0;
        char x = '0';
        for(int i=0;i<s.length();i++){
            if(x=='0'){
                x = s.charAt(i);
                xCnt++;
                continue;
            }
            
            if(x==s.charAt(i)){
                xCnt++;
            }else {
                notXCnt++;
            }
            
            if(xCnt==notXCnt){
                xCnt = 0;
                notXCnt = 0;
                x = '0';
                answer++;
            }
        }
        
        if(x != '0') answer++;
        
        return answer;
    }
}