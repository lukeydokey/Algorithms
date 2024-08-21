class Solution {
    public String solution(String[] survey, int[] choices) {
        StringBuilder sb = new StringBuilder();
        int[] score = {-3,-2,-1,0,1,2,3};
        String[] type = {"RT","CF","JM","AN"};
        String[] reverseType = {"TR","FC","MJ","NA"};
        int[] result = new int[4];

        for(int i =0;i<survey.length;i++) {
            for(int j =0; j< 4 ; j++){
                if(survey[i].equals(type[j])) {
                    result[j] += score[choices[i]-1];
                    break;
                }
                if(survey[i].equals(reverseType[j])) {
                    result[j] -= score[choices[i]-1];
                    break;
                }
            }
        }
        for(int i =0; i<4; i++) {
            if(result[i] > 0) {
                sb.append(type[i].charAt(1));
            }else{
                sb.append(type[i].charAt(0));
            }
        }
        return sb.toString();
    }
}