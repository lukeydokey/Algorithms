class Solution {
    /*
    brown = (x * y) - yellow
    yellow =  (x-2) * (y-2)
    x*y = brown + yellow
    x = (brown + yellow) / y
    */
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int y = 3;
        int x = (brown + yellow) / y;
        while((x-2)*(y-2) != yellow){
            x = (brown + yellow) / ++y;
        }
        
        answer[0] = x;
        answer[1] = y;
        return answer;
    }
}