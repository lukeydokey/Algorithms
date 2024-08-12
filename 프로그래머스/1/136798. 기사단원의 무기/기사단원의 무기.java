class Solution {
    public int solution(int number, int limit, int power) {
        
        int answer = 1; // 1번째 기사
        for(int i=2;i<=number;i++){
            answer += cal(i, limit, power);
        }
        
        return answer;
    }
    public int cal(int num, int limit, int power){
        int cnt = 2;
        for(int i=2;i<=Math.sqrt(num);i++){
            if(num%i==0){
                if(i==Math.sqrt(num))cnt++;
                else cnt += 2;
            }
        }
        return (cnt > limit) ? power : cnt;
    }
}