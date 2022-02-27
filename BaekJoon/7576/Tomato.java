package ssafy.com.algo17;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*

백준 7576 토마토

 */


public class Tomato {
	
	static int N, M, dayCnt, zCnt;
	static int [][] map;
	static Queue<int[]> q;
	static int [][] del = {
			{1,0},
			{0,1},
			{-1,0},
			{0,-1}
	};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int [N][M];
		q = new LinkedList<>();
		zCnt = 0;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken()); // 맵 저장
				if(map[i][j]==1) {
					q.offer(new int[]{i, j, 0}); // 익은 토마토 가로위치, 세로위치, 0일차
				}else if(map[i][j]==0) {
					zCnt++; //익지않은 토마토 갯수
				}
				
			}
		}
		
		dayCnt = 0;
		bfs();
		
		
		if(zCnt>0) {
			bw.write("-1");
		}else {
			bw.write(dayCnt+"");
		}
		
		bw.flush();
		bw.close();
	}
	static void bfs() {
		
		while(!q.isEmpty()) {
			int[] tomato = q.poll();
			
			int ti = tomato[0];
			int tj = tomato[1];
			int day = tomato[2];
			
			dayCnt = Math.max(dayCnt, day);
			
			for(int d=0;d<4;d++) {
				int ni = ti + del[d][0];
				int nj = tj + del[d][1];
				
				if(ni>=0&&ni<N&&nj>=0&&nj<M) { //맵을 벗어나지않음
					if(map[ni][nj]==0) { // 익지않은 토마토가 있는 곳이면
						map[ni][nj] = 1;
						zCnt --;
						q.offer(new int[] {ni, nj, day+1});
					}
				}
			}
			
		}
		
	}
}
