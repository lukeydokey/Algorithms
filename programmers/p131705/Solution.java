package programmers.p131705;

class Solution {
    public int result = 0;
    public int solution(int[] number) {
        cal(0,0,0,number);
        return result;
    }
    public void cal(int cnt, int cur, int sum, int[] number){
        if(cnt==3 && sum == 0){
            result++;
            return;
        }else{
            for(int i=cur;i<number.length;i++){
                cal(cnt+1, i+1, sum+number[i], number);
            }
        }
    }
}