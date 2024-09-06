class Solution {
    public int solution(int[] arr) {
        int answer = 0;
        if (arr.length==1) return arr[1];
        answer = arr[0]*arr[1] / gcd(arr[0],arr[1]);
        for(int i=2;i<arr.length;i++){
            answer = answer*arr[i] / gcd(answer,arr[i]);
        }
        return answer;
    }
    public int gcd(int a, int b){
        if(a%b == 0){
            return b;
        }
        
        return gcd(b, a%b);
    }
}