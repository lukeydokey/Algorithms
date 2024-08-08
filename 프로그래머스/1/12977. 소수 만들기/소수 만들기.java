class Solution {
    public int cnt = 0;
    public int solution(int[] nums) {

        cal(nums,0,0,0);

        return cnt;
    }
    public void cal(int[] nums, int cur, int pick, int sum){
        if(pick == 3){
            if(isPrime(sum))cnt++;
        }else{
            for(int i=cur;i<nums.length;i++){
                cal(nums, i+1, pick+1, sum+nums[i]);
            }
        }
    }
    
    public boolean isPrime(int n){
        if(n==0 || n==1) return false;
        for(int i=2;i<=Math.sqrt(n);i++){
            if(n%i==0) return false;
        }
        return true;
    }
}