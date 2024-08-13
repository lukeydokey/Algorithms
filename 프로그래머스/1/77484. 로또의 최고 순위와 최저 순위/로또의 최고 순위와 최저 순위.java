class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int winCnt = 0; // 맞는 숫자 카운트
        int zCnt = 0; // 알아볼 수 없는 수 카운트
        for(int i=0;i<6;i++){
            if(lottos[i]==0){
                zCnt++;
                continue;
            }
            for(int j=0;j<6;j++){
                if(lottos[i]==win_nums[j]){
                    winCnt++;
                    break;
                }
            }
        }
        
        int[] answer = new int[2];
        answer[0] = checkLotto(winCnt+zCnt);
        answer[1] = checkLotto(winCnt);
        return answer;
    }
    public int checkLotto(int num){
        switch(num){
            case 6:
                return 1;
            case 5:
                return 2;
            case 4:
                return 3;
            case 3:
                return 4;
            case 2:
                return 5;
            default:
                return 6;
        }
    }
}