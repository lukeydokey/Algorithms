package ssafy.com.algo10;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*

백준 14696 딱지놀이

*/

public class Game {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int n;
	public static void main(String[] args) throws IOException{
		n = Integer.parseInt(br.readLine());
		
		for(int r=0;r<n;r++) { // 라운드
			int [] a = new int[4+1]; //어린이 A의 딱지갯수
			int [] b = new int[4+1]; //어린이 B의 딱지갯수
			
			//어린이 A의 딱지 입력
			st = new StringTokenizer(br.readLine(), " ");
			int limit = Integer.parseInt(st.nextToken());
			for(int i=0;i<limit;i++) {
				int tmp = Integer.parseInt(st.nextToken());
				a[tmp]++;
			}
			//어린이 B의 딱지 입력
			st = new StringTokenizer(br.readLine(), " ");
			limit = Integer.parseInt(st.nextToken());
			for(int i=0;i<limit;i++) {
				int tmp = Integer.parseInt(st.nextToken());
				b[tmp]++;
			}
			//각자 갯수 비교
			char result ='D';
			if(a[4]>b[4]) { // 별의 갯수비교
				result = 'A';
			}else if(a[4]<b[4]) {
				result = 'B';
			}else if(a[3]>b[3]) { // 동그라미의 갯수비교
				result = 'A';
			}else if(a[3]<b[3]) {
				result = 'B';
			}else if(a[2]>b[2]) { // 네모의 갯수비교
				result = 'A';
			}else if(a[2]<b[2]) {
				result = 'B';
			}else if(a[1]>b[1]) { // 세모의 갯수비교
				result = 'A';
			}else if(a[1]<b[1]) {
				result = 'B';
			}
			//라운드 결과 출력
			bw.write(String.format("%c\n", result));
		}
		
		bw.flush();
		bw.close();
	}

}
