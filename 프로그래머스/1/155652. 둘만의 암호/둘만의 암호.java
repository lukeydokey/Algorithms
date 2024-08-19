class Solution {
    public String solution(String s, String skip, int index) {
        StringBuilder sb = new StringBuilder();
        
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            int cnt = 0;
            for(int j=1;j<=index;){
                if(skip.contains((char)((c - 'a' + cnt + 1) % 26 + 'a')+"")){
                    cnt++;
                }else {
                    cnt++;
                    j++;
                }
            }
            char nChar = (char)((c - 'a' + cnt) % 26 + 'a');
            sb.append(nChar);
        }
        
        return sb.toString();
    }
}