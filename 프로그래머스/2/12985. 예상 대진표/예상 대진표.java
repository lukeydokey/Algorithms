class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 0;

        while(a!=b){
            answer++;
            a = a % 2 == 1 ? (a + 1)/2 : a / 2;
            b = b % 2 == 1 ? (b + 1)/2 : b / 2;
            if(a==0) a = 1;
            if(b==0) b = 1;
        }

        return answer;
    }
}