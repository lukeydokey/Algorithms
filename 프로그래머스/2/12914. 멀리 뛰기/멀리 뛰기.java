class Solution {
    /*
    n = 1 / 1
    n = 2 / 2
    n = 3 / 3
    n = 4 / 5
    n = 5 / 8
    */
    public long solution(int n) {
        if(n==1) return 1L;
        else if(n==2) return 2L;
        
        long[] nums = new long[n+1];
        nums[1] = 1L;
        nums[2] = 2L;
        long answer = 0;
        for(int i=3;i<=n;i++){
            nums[i] = (nums[i-1]%1234567 + nums[i-2]%1234567);
        }
        
        return nums[n] % 1234567;
    }
}