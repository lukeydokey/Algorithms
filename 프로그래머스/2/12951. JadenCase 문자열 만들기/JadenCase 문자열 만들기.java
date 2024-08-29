class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==' ') {
                sb.append(" ");
                continue;
            }
            if((i==0||(i>0&&s.charAt(i-1)==' '))&&(s.charAt(i)>='a'&&s.charAt(i)<='z')){
                sb.append(s.substring(i,i+1).toUpperCase());
            }else if((i>0&&s.charAt(i-1)!=' ')&&(s.charAt(i)>='A'&&s.charAt(i)<='Z')){
                sb.append(s.substring(i,i+1).toLowerCase());
            }else{
                sb.append(s.substring(i,i+1));
            }
            
        }
        return sb.toString();
    }
}