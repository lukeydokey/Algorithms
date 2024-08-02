class Solution {
    public int solution(String s) {
        StringBuilder sb = new StringBuilder();
        /*
        0 z+4
        1 o+3
        2 t+3(2 뒤가 o면 2)
        3 t+5(2 뒤가 o아니면 3)
        4 f+4(3 뒤가 r이면 4)
        5 f+4(3 뒤가 r아니면 5)
        6 s+3(2 뒤가 x면 6)
        7 s+5(2 뒤가 x아니면 7)
        8 e+5
        9 n+4
        */
        int i=0;
        while(i<s.length()){
            if(s.charAt(i)>='0'&&s.charAt(i)<='9') {
                sb.append(s.charAt(i));
                i++;
                continue;
            }
            switch(s.charAt(i)){
                case 'z':
                    sb.append("0");
                    i+=4;
                    break;
                case 'o':
                    sb.append("1");
                    i+=3;
                    break;
                case 't':
                    if(s.charAt(i+2)=='o'){
                        sb.append("2");
                        i+=3;
                    }else {
                        sb.append("3");
                        i+=5;
                    }
                    break;
                case 'f':
                    if(s.charAt(i+3)=='r'){
                        sb.append("4");
                        i+=4;
                    }else {
                        sb.append("5");
                        i+=4;
                    }
                    break;
                case 's':
                    if(s.charAt(i+2)=='x'){
                        sb.append("6");
                        i+=3;
                    }else {
                        sb.append("7");
                        i+=5;
                    }
                    break;
                case 'e':
                    sb.append("8");
                    i+=5;
                    break;
                case 'n':
                    sb.append("9");
                    i+=4;
                    break;
            }
        }
        
        int answer = Integer.parseInt(sb.toString());
        return answer;
    }
}