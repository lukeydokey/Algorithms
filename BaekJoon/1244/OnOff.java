package ssafy.com.algo10;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*

백준 1244번 스위치 켜고끄기

 */

public class OnOff {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int[] state;
	public static void main(String[] args) throws IOException{
		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		state = new int[n];
		for(int i=0;i<n;i++) {
			state[i] = Integer.parseInt(st.nextToken()); // 스위치 상태 저장
		}
		
		//학생 수 저장
		int s = Integer.parseInt(br.readLine());
		//학생 연산
		for(int i=0;i<s;i++) {
			st =new StringTokenizer(br.readLine(), " ");
			int gender = Integer.parseInt(st.nextToken());
			int target = Integer.parseInt(st.nextToken());
			
			func(gender, target, n);
		}
		
		for(int i=0;i<n;i++) {
			if((i+1)%20==0) {
				bw.write(state[i]+"\n");
			}else {
				bw.write(state[i]+" ");
			}
		}
		bw.flush();
		bw.close();
	}
	
	static void func(int g, int t, int n) { //g = gender, t = target, n = state.length
		if(g==1) { // 남학생
			for(int i=0;i<n;i++) {
				if(i==t-1) { // 타겟
					if(state[i]==1)
						state[i]=0;
					else {
						state[i]=1;
					}
				}else if(i>t-1&&(i-(t-1))%t==0) { //타겟 보다 크고 타겟의 배수
					if(state[i]==1)
						state[i]=0;
					else {
						state[i]=1;
					}
				}
			}
			
		}else { // 여학생
			for(int i=0;i<n/2;i++) {
				int ri = t-1 + i; //오른쪽
				int li = t-1 - i; //왼쪽
				if(ri>=n||li<0) { //스위치 벗어나면 break
					break;
				}
				if(state[li]==state[ri]) { //대칭
					if(state[ri]==1) {
						state[ri]=0;
						state[li]=0;
					}
					else {
						state[ri]=1;
						state[li]=1;
					}
				}else { //대칭아님
					break;
				}
			}
		}
		
	}
}
