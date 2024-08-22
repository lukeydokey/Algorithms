class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = new int[4];
        answer[0] = wallpaper.length;
        answer[1] = wallpaper[0].length();
        for(int i=0;i<wallpaper.length;i++){
            String[] files = wallpaper[i].split("");
            for(int j=0;j<files.length;j++){
                if(files[j].equals(".")) continue;
                if(i<answer[0]) answer[0] = i;
                if(j<answer[1]) answer[1] = j;
                if(i>=answer[2]) answer[2] = i+1;
                if(j>=answer[3]) answer[3] = j+1;
            }
        }
        
        return answer;
    }
}