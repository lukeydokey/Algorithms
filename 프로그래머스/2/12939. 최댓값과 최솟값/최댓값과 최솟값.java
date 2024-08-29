class Solution {
    public String solution(String s) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        String[] numbers = s.split(" ");
        for(int i=0;i<numbers.length;i++){
            min = Math.min(min, Integer.parseInt(numbers[i]));
            max = Math.max(max, Integer.parseInt(numbers[i]));
        }
        String answer = min + " " + max;
        return answer;
    }
}