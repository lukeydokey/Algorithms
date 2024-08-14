class Solution {
    public String solution(String X, String Y) {
        int[] numX = new int[10];
        int[] numY = new int[10];
        for(int i=0;i<X.length();i++){
            numX[Integer.parseInt(X.charAt(i)+"")]++;
        }
        for(int i=0;i<Y.length();i++){
            numY[Integer.parseInt(Y.charAt(i)+"")]++;
        }
        StringBuilder sb = new StringBuilder();
        boolean flag = false; // 0이 아닌 공통된 수가 있는지 체크
        for(int i=9;i>=0;i--){
            if(numX[i]==0||numY[i]==0)continue;
            if(i>0&&!flag) flag = true;
            while(numX[i]>0&&numY[i]>0){
                sb.append(i);
                numX[i]--;
                numY[i]--;
            }
        }
        if(sb.toString().equals("")) return "-1";
        else if(!flag) return "0";
        return sb.toString();
    }
}