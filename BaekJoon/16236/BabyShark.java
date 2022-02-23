package ssafy.com.algo15;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/*

백준 16236 아기 상어

 */

public class BabyShark {
	
	static class Point implements Comparable<Point>{
		int x, y, d;

		public Point(int x, int y, int d) {
			super();
			this.x = x;
			this.y = y;
			this.d = d;
		}

		@Override
		public int compareTo(Point o) {
			if(d==o.d) {
				if(x==o.x) {
					return Integer.compare(y, o.y);
				}
				return Integer.compare(x, o.x);
			}
			return Integer.compare(d, o.d);
		}
	}
	static int [][] map;
	static boolean[][] visited;
	static int N, bi, bj, bSize;
	static int[][] dir = {
			{-1, 0},
			{0, -1},
			{0, 1},
			{1, 0}
	};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0;j<N;j++) {
				int a = Integer.parseInt(st.nextToken());
				map[i][j] = a; // map 저장
				if(a==9) {
					bi = i; //아기 상어 초기 위치
					bj = j;
					map[i][j] = 0;
					bSize = 2; // 아기 상어 초기 크기
				}
			}
		}
		
		int result = 0;
		int exp = 0;
		while(true) {
			PriorityQueue<Point> fish = new PriorityQueue<>(); //먹을 수 있는 물고기 리스트
			
			// BFS로 거리 탐색
			Queue<Point> q = new LinkedList <>();
			visited = new boolean[N][N];
			
			q.offer(new Point(bi,bj, 0));
			visited[bi][bj] = true;
			
			while(!q.isEmpty()) {
				Point p = q.poll();
				
				for (int d = 0; d < 4; d++) {
					int nx = p.x + dir[d][0];
					int ny = p.y + dir[d][1];
					
					if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny]&& map[nx][ny] <= bSize) { // 이동할 곳 물고기가 상어보다 크면 안됨
						int nd = p.d+1;
						visited[nx][ny] = true;
						q.offer(new Point(nx, ny, nd));
						if(map[nx][ny]!=0&&map[nx][ny]<bSize) { // 먹을 수 있는 물고기 발견
							fish.offer(new Point(nx, ny, nd));
						}
					}
				}
			}
			
			// 먹을 수 있는 물고기가 없음
			if(fish.isEmpty())break;
			
			//먹이를 먹으러 이동함
			Point po = fish.poll();
			map[po.x][po.y] = 0;
			result+=po.d; 
			bi = po.x;
			bj = po.y;
			if(++exp==bSize) { //크기만큼 물고기 먹으면 사이즈 업
				bSize++;
				exp = 0;
			}
		}
		
		bw.write(result+"");
		bw.flush();
		bw.close();
	}
}
