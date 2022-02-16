package ssafy.com.algo10;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*

백준 1592 영식이와 친구들

*/

public class YoungSik {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(br.readLine(), " ");
		
		//사람 수
		int n = Integer.parseInt(st.nextToken());
		//게임 종료 횟수
		int m = Integer.parseInt(st.nextToken());
		// +- 몇번째 사람에게 전달하는지
		int l = Integer.parseInt(st.nextToken());
		
		int [] cnt = new int[n+1];
		int count = 0; //전체 공 주고받는 횟수
		int cur = 1;
		cnt[1]++; // 시작은 1번
		while(cnt[cur]<m) { // 한명이 m번 공을 받으면 종료
			if(cnt[cur]%2==1) { //홀수번 공을 받음
				if(cur+l<=n) { //1바퀴 돌지않음
					cur += l;
				}else { //1바퀴 넘어감
					cur = l- (n-cur);
				}
			}else { //짝수번 공을 받음
				if(cur-l>=1) { // 1바퀴 돌지않음
					cur -= l;
				}else { //1바퀴 넘어감
					cur = n - (l-cur);
				}
			}
			count++;
			cnt[cur]++;
		}
		
		bw.write(count+"");
		bw.flush();
		bw.close();
	}

}
