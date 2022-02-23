package ssafy.com.algo15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/*

백준 10026 적록색약

 */

public class RedGreen {
	
	static class Point{
		int x, y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	static int N, cnt, cntRG;
	static char[][] map;
	static boolean[][] visited;
	static boolean[][] visitedRG;
	static int[][] del = {
			{1, 0},
			{-1, 0},
			{0, 1},
			{0, -1}
	};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		for(int i=0;i<N;i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		visited = new boolean[N][N];
		cnt = 0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(!visited[i][j]) { // 방문하지 않음
					char cur = map[i][j]; // 현재 탐색 구역
					bfs(cur, i, j);
					cnt++;
				}
			}
		}
		
		visitedRG = new boolean[N][N];
		cntRG = 0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(!visitedRG[i][j]) { // 방문하지 않음
					char cur = map[i][j]; // 현재 탐색 구역
					bfsRG(cur, i, j);
					cntRG++;
				}
			}
		}
		
		
		
		System.out.println(cnt);
		System.out.println(cntRG);
		
	}
	
	static void bfs(char cur, int si, int sj) { //일반 bfs
		Queue<Point> q = new LinkedList<>();
		
		q.offer(new Point(si, sj)); // 시작 위치 넣기
		visited[si][sj] = true;
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			
			for(int d=0;d<4;d++) {
				int ni = p.x + del[d][0];
				int nj = p.y + del[d][1];
				
				if(ni>=0&&ni<N&&nj>=0&&nj<N&&!visited[ni][nj]&&map[ni][nj]==cur) { // 같은 그룹
					q.offer(new Point(ni,nj));
					visited[ni][nj]= true;
				}
				
			}
		}
	}
	static void bfsRG(char cur, int si, int sj) { //적녹 색약 bfs
		Queue<Point> q = new LinkedList<>();
		
		q.offer(new Point(si, sj)); // 시작 위치 넣기
		visitedRG[si][sj] = true;
		
		while (!q.isEmpty()) {
			Point p = q.poll();
			
			for (int d = 0; d < 4; d++) {
				int ni = p.x + del[d][0];
				int nj = p.y + del[d][1];
				
				if (ni >= 0 && ni < N && nj >= 0 && nj < N && !visitedRG[ni][nj]
						&& ( map[ni][nj] == cur || (cur=='G' && map[ni][nj] == 'R') || (cur=='R' && map[ni][nj] == 'G')  ) ) { // 같은 그룹
					q.offer(new Point(ni, nj));
					visitedRG[ni][nj] = true;
				}
				
			}
		}
	}
}
