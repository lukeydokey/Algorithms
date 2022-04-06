package day6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*

백준 17281 야구

 */

public class Baseball {
	static int N, max;
	static int[][] player;
	static int[] order;
	static boolean[] visited;
	public static void main(String[] args) throws IOException{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		player = new int[N][9];
		order = new int[9];
		visited = new boolean[9];
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j=0;j<9;j++) {
				player[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		max = 0;
		visited[0]=true;
		func(0);
		bw.write(max+"");
		bw.flush();
		bw.close();
	}
	static void func(int cnt) {
		if(cnt==9) {
			calc();
		}else {
			if(cnt==3)
				func(cnt+1);
			else {
				for(int i=1;i<9;i++) {
					if(!visited[i]) {
						visited[i]=true;
						order[cnt] = i;
						func(cnt+1);
						visited[i]=false;
					}
				}
			}
		}
	}
	static void calc() {
		int outCnt = 0;
		int cur = 0;
		int score = 0;
		boolean[] base = new boolean[3];
		for(int i=0;i<N;i++) {
			while(true) {
				int hit = player[i][order[(cur++)%9]]; // 현재 플레이어의 타격기록
				switch(hit) {
				case 0:
					outCnt++;
					break;
				case 1:
					if(base[2]) {
						score++;
					}
					base[2] = base[1];
					base[1] = base[0];
					base[0]=true;
					break;
				case 2:
					if(base[2]) {
						score++;
					}
					if(base[1]) {
						score++;
					}
					base[2]=base[0];
					base[1]=true;
					base[0]=false;
					break;
				case 3:
					if(base[2]) {
						score++;
					}
					if(base[1]) {
						score++;
						base[1]=false;
					}
					if(base[0]) {
						score++;
						base[0]=false;
					}
					base[2]=true;
					break;
				case 4:
					if(base[2]) {
						score++;
						base[2]=false;
					}
					if(base[1]) {
						score++;
						base[1]=false;
					}
					if(base[0]) {
						score++;
						base[0]=false;
					}
					score++;
					break;
				}
				if(outCnt==3) {
					base[2]=false;
					base[1]=false;
					base[0]=false;
					outCnt=0;
					break;
				}
			}
		}
		
		max = Math.max(max, score);
	}
}
