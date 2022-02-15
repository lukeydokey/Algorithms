package ssafy.com.algo9;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*

백준 2839번 설탕 배달

 */


public class Sugar {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException{
		int n = Integer.parseInt(br.readLine());
		
		int result = 0;
		if(n==4||n==7) { // 4나 7은 딱 맞출수 없음
			result = -1;
		}else if(n%5==0) { // 5의 배수는 5로 나눈 수
			result = n/5;
		}else if(n%5==1||n%5==3) { // 5의배수 +1, +3은 나눈횟수 +1 ( ex 11 = 3+3+5, 13 = 5+5+3 -> 2+1)
			result = n/5 + 1;
		}else if(n%5==2||n%5==4) { // 5의배수 +2, +4 는 나눈횟수 +2 ( ex 12 = 3+3+3+3, 14 = 3+3+3+5 -> 2+2)
			result = n/5 + 2;
		}
		
		bw.write(String.format("%d", result));
		bw.flush();
		bw.close();
		
	}

}
