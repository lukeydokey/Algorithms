class Solution {
    public String solution(String s, int n) {
        int a = (int)'a';
        int A = (int)'A';
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==' ')continue;
            int cur = (int)s.charAt(i);
            if(cur>=a){
                cur = ((cur-a)+n)%26 + a;
            }else {
                cur = ((cur-A)+n)%26 + A;
            }
            s = s.substring(0,i) + (char)cur + s.substring(i+1);
        }
        String answer = s;
        return answer;
    }
}