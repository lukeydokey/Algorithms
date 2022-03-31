package day1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


/*

백준 1600 말이 되고픈 원숭이

*/

public class Monkey {
	
	static int[][] hdel = { //말 이동방식
			{2, -1},
			{1, -2},
			{2, 1},
			{1, 2},
			{-2, -1},
			{-1, -2},
			{-2, 1},
			{-1, 2}
	};
	static int[][] del = { //4방 이동
			{0, 1},
			{1, 0},
			{0, -1},
			{-1, 0}
	};
	
	static class point {
		int k, i, j, m;

		public point(int k, int i, int j, int m) {
			super();
			this.k = k;
			this.i = i;
			this.j = j;
			this.m = m;
		}
		
	}
	
	static int [][] map;
	static boolean [][][] visited;
	static int w,h;
	public static void main(String[] args) throws IOException{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringTokenizer st;
		
		int k = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(),  " ");
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		
		map = new int[h][w];
		visited = new boolean[k+1][h][w];
		for(int i=0;i<h;i++) {
			st= new StringTokenizer(br.readLine(), " ");
			for(int j=0;j<w;j++) {
				int cur = Integer.parseInt(st.nextToken());
				if(cur==1) map[i][j] = -1; // 장애물
				else map[i][j] = Integer.MAX_VALUE; // 평지
			}
		}
		
		bfs(k);
		
		
		if(map[h-1][w-1]==Integer.MAX_VALUE) {
			bw.write(-1+"");
		}else {
			bw.write(map[h-1][w-1]+"");
		}
		
		bw.flush();
		bw.close();
		
	}
	static void bfs(int k) {
		Queue<point> q = new LinkedList<>();
		q.offer(new point(k, 0, 0, 0)); //시작 점
		visited[0][0][0] = true;
		
		while(!q.isEmpty()) {
			point p = q.poll();
			
			if(p.m>map[h-1][w-1]) continue; // 최단 도착거리보다 이미 많이 이동
			
			if(map[p.i][p.j]>p.m) { // 지점 까지 최단거리 갱신
				map[p.i][p.j] = p.m;
			}
			
			
			for(int d=0;d<4;d++) { //4방 이동
				int ni = p.i + del[d][0];
				int nj = p.j + del[d][1];
				
				if(ni>=0&&ni<h&&nj>=0&&nj<w) {
					if(map[ni][nj]!=-1) { //새 지점이 벽이 아닐 때만 큐에 삽입
						if(!visited[k-p.k][ni][nj]) {
							q.offer(new point(p.k, ni, nj, p.m+1));
							visited[k-p.k][ni][nj] = true;
						}
					}
					
				}
				
			}
			
			if(p.k>0) { // 말처럼 이동 가능한 횟수가 남아있을 때
				for(int d=0;d<8;d++) { //말 처럼 이동
					int ni = p.i + hdel[d][0];
					int nj = p.j + hdel[d][1];
					
					if(ni>=0&&ni<h&&nj>=0&&nj<w) {
						if(map[ni][nj]!=-1) { //새 지점이 벽이 아닐 때만 큐에 삽입
							if(!visited[k-(p.k-1)][ni][nj]) {
								q.offer(new point(p.k-1, ni, nj, p.m+1)); //말처럼 이동했으니 횟수 -1
								visited[k-(p.k-1)][ni][nj] = true;
							}
						}
						
					}
					
				}
			}
		}
	}
}
