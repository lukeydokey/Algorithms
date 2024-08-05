class Solution {
    public int count = 0;
    public int solution(int a, int b, int n) {
        cal(a,b,n);
        return count;
    }
    public void cal(int a, int b, int n){ // a 빈 병, b 돌려주는 콜라 수, n 가진 병 갯수
        if(n<a) return;
        else {
            int received = (n / a) * b; // 받는 병 갯수
            count += received;
            cal(a,b, (n % a) + received);
        }
    }
}