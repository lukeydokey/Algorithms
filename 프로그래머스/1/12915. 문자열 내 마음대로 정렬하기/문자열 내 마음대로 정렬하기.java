import java.util.*;

class Solution {
    class NewString implements Comparable<NewString>{
        String str;
        int n;
        public NewString(String str, int n){
            this.str = str;
            this.n = n;
        }
        @Override
        public int compareTo(NewString o){
            if(this.str.charAt(n)==o.str.charAt(o.n)){
                return this.str.compareTo(o.str);
            }else {
                return this.str.charAt(n) - o.str.charAt(o.n);
            }
        }
    }
    public String[] solution(String[] strings, int n) {
        ArrayList<NewString> list = new ArrayList<>();
        for(int i=0;i<strings.length;i++){
            list.add(new NewString(strings[i], n));
        }
        Collections.sort(list);
        String[] answer = new String[strings.length];
        for(int i=0;i<strings.length;i++){
            answer[i] = list.get(i).str;
        }
        return answer;
    }
}