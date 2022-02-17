package ssafy.com.algo11;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/*

백준 1931 회의실 배정

 */

public class Meeting {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int n;
	static int [][] times;
	public static void main(String[] args) throws IOException{
		n = Integer.parseInt(br.readLine());
		times = new int[n][2];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			times[i][0] = Integer.parseInt(st.nextToken());
			times[i][1] = Integer.parseInt(st.nextToken());
		}
		
		//끝나는 시간 기준 오름차순 정렬
		Arrays.sort(times, (o1,o2)->{
			if(o1[1]==o2[1]) {
				return o1[0] - o2[0];
			}else {
				return o1[1] - o2[1];
			}
		});
		
		bw.write(func()+"");
		bw.flush();
		bw.close();
	}
	
	static int func() {
		//첫 회의 시작
		int curStart = times[0][0];
		int curEnd = times[0][1];
		int cnt=1;
		for(int i=1;i<n;i++) {
			if(times[i][0]<curEnd) continue; // 회의 아직 안끝남
			else { //이 전 회의 끝남
				curStart = times[i][0];
				curEnd = times[i][1];
				cnt++;
			}
		}
		
		return cnt;
	}
}
