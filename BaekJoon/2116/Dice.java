package ssafy.com.algo10;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*

백준 2116 주사위 쌓기

*/

public class Dice {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int n;
	static int[][] dice;
	static int sumMax=Integer.MIN_VALUE;
	public static void main(String[] args) throws IOException{
		n = Integer.parseInt(br.readLine());
		dice = new int[n][6];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0;j<6;j++) {
				dice[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=1;i<=6;i++) {
			func(0, i, 0);
		}
		
		bw.write(sumMax+"");
		bw.flush();
		bw.close();
	}
	static void func(int cnt, int num, int sum) {
		for(int i=0;i<6;i++) {
			if(dice[cnt][i]==num) { //현재 주사위 선택
				int roof = 0;
				//천장 찾음
				if(i==0) {
					roof = dice[cnt][5];
				}else if(i==1) {
					roof = dice[cnt][3];
				}else if(i==2) {
					roof = dice[cnt][4];
				}else if(i==3) {
					roof = dice[cnt][1];
				}else if(i==4) {
					roof = dice[cnt][2];
				}else if(i==5) {
					roof = dice[cnt][0];
				}
				
				//옆면 최대값 구하기
				int max=0;
				for(int j=1;j<=6;j++) {
					if(j==num||j==roof) continue;
					if(max<j) {
						max = j;
					}
				}
				
				if(cnt==n-1) { //주사위 다 선택됨
					if(sum+max>sumMax) {
						sumMax = sum+max;
					}
					return;
				}
				//다음 주사위
				func(cnt+1, roof, sum+max);
			}
		}
	}
}
