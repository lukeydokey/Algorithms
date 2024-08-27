class Solution {
    public int[][] del = {
        {0, 1},
        {0, -1},
        {1, 0},
        {-1, 0}
    };
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        for(int i=0;i<park.length;i++){
            for(int j=0;j<park[0].length();j++){
                if(park[i].charAt(j)=='S'){
                    answer[0] = i;
                    answer[1] = j;
                }
            }
        }
        
        for(int i=0;i<routes.length;i++){
            String[] tmp = routes[i].split(" ");
            int n = Integer.parseInt(tmp[1]);
            int[] tmpDog = answer.clone();
            boolean flag = false; // 장애물 만나는지 체크하는 flag
            for(int j=0;j<n;j++){
                switch(tmp[0]){
                    case "E":
                        tmpDog[0] += del[0][0];
                        tmpDog[1] += del[0][1];
                        break;
                    case "W":
                        tmpDog[0] += del[1][0];
                        tmpDog[1] += del[1][1];
                        break;
                    case "S":
                        tmpDog[0] += del[2][0];
                        tmpDog[1] += del[2][1];
                        break;
                    case "N":
                        tmpDog[0] += del[3][0];
                        tmpDog[1] += del[3][1];
                        break;
                }
                if(
                    tmpDog[0]<0||tmpDog[0]>=park.length||
                    tmpDog[1]<0||tmpDog[1]>=park[0].length()||
                    park[tmpDog[0]].charAt(tmpDog[1])=='X'
                  ) {
                    flag = true;
                    break;
                }
            }
            if(!flag){
                answer[0] = tmpDog[0];
                answer[1] = tmpDog[1];
            }
        }
        
        return answer;
    }
}