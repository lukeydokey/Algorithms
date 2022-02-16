package ssafy.com.algo10;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*

백준 2567번 색종이-2

 */

public class ColoredPaper3 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int n, cnt;
	static int [][] paper = new int[101][101];
	static int [][] dir = {
			{1,0},
			{0,1},
			{-1,0},
			{0,-1}
	};
	public static void main(String[] args) throws IOException{
		n =Integer.parseInt(br.readLine());
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			for(int a=x;a<x+10;a++) {
				for(int b=y;b<y+10;b++) {
					paper[a][b] = 1; //색종이 마스킹
				}
			}
		}
		
		func();
		
		bw.write(cnt+"");
		bw.flush();
		bw.close();
	}
	static void func() {
		//전체 순회
		for(int i=1;i<=100;i++) {
			for(int j=1;j<=100;j++) {
				//현재위치가 색종이일때 사방에 색칠안된 부분이 있는지 체크
				if(paper[i][j]==1) {
					check(i,j);
				}
			}
		}
	}
	
	static void check(int x, int y) { // 좌표기준 4방향에 흰 부분이 있는지 체크
		for(int d=0;d<4;d++) {
			int dx = x + dir[d][0];
			int dy = y + dir[d][1];
			
			if(paper[dx][dy]==0||dx<1||dx>100||dy<1||dy>100) { //흰 부분이 있다
				cnt++;
			}
		}
		
	}
}
