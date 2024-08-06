class Solution {
    public boolean[] selected1, selected2;
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        selected1 = new boolean[cards1.length];
        selected2 = new boolean[cards2.length];
        
        String[] cards = new String[goal.length];
        
        if(cal(cards1, cards2, goal, cards, 0))return "Yes";
        return "No";
    }
    
    public boolean cal(String[] cards1, String[] cards2, String[] goal, String[] cards, int cnt){
        if(cnt==goal.length) return true;
        for(int i=0;i<cards1.length;i++){
            if(i>0&&!selected1[i-1]) break;
            if(!selected1[i] && goal[cnt].equals(cards1[i])) {
                selected1[i] = true;
                if(cal(cards1, cards2, goal, cards, cnt+1)) return true;
            }
        }
        for(int i=0;i<cards2.length;i++){
            if(i>0&&!selected2[i-1]) break;
            if(!selected2[i] && goal[cnt].equals(cards2[i])) {
                selected2[i] = true;
                if(cal(cards1, cards2, goal, cards, cnt+1)) return true;
            }
        }
        return false;
    }
}