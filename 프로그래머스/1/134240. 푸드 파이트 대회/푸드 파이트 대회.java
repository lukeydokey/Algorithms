class Solution {
    public String solution(int[] food) {
        
        StringBuilder sb = new StringBuilder();
        
        int [] count = new int[food.length];
        count[0] = 1;
        int length = 0;
        for(int i=1;i<food.length;i++){
            count[i] = food[i]/2;
            length += food[i]/2;
        }
        
        // 왼쪽 선수
        for(int i=1;i<food.length;i++){
            int cur = i;
            for(int j=0;j<count[cur];j++){
                sb.append(cur + "");
            }
        }
        
        sb.append("0"); // 물
        
        // 오른쪽 선수
        for(int i=food.length-1;i>0;i--){
            int cur = i;
            for(int j=0;j<count[cur];j++){
                sb.append(cur + "");
            }
        }
        
        
        return sb.toString();
    }
}