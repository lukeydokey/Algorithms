class Solution {
    public int solution(int n) {
        long[] fibos = new long[n+1];
        fibos[0] = 0L;
        fibos[1] = 1L;
        for(int i=2;i<=n;i++){
            fibos[i] = fibo(i, fibos);
        }
        return (int)fibos[n];
    }
    public long fibo(int n, long[] fibos){
        if(n == 0) return 0L;
        else if(n == 1) return 1L;
        else return (fibos[n-1] % 1234567L + fibos[n-2] % 1234567L) % 1234567L;
    }
}