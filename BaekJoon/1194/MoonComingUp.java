package day3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*

백준 1194 달이 차오른다 가자

*/

public class MoonComingUp {

	static class point {
		int i, j, m, key;
		
		public point(int i, int j, int m, int key) {
			super();
			this.i = i;
			this.j = j;
			this.m = m;
			this.key = key;
		}
	}
	
	static int[][] del = {
			{0, 1},
			{1, 0},
			{0, -1},
			{-1, 0}
	};
	static boolean[][][] visited;
	
	public static void main(String[] args) throws IOException{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		char [][] map = new char[N][M];
		visited = new boolean[64][N][M];
		int si = 0;
		int sj = 0;
		for(int i=0;i<N;i++) {
			String tmp = br.readLine();
			for(int j=0;j<M;j++) {
				if(tmp.charAt(j)=='0') {
					si = i;
					sj = j;
				}
				map[i][j] = tmp.charAt(j);
			}
		}

		int result = function(map, N, M, si, sj);
		
		
		bw.write(String.format("%d", result));
		bw.flush();
		bw.close();
		
	}
	static int function(char[][] map, int N, int M, int si, int sj) {
		int result = -1;
		Queue<point> q = new LinkedList<>();
		q.offer(new point(si,sj,0,0)); // i j m key
		visited[0][si][sj] = true;
		
		while(!q.isEmpty()) {
			point p = q.poll();
			
			for(int d=0;d<4;d++) {
				int ni = p.i + del[d][0];
				int nj = p.j + del[d][1];
				
				if(ni<0||ni>=N||nj<0||nj>=M||visited[p.key][ni][nj])continue;

				if(map[ni][nj]=='1') {
					result = p.m+1;
					return result;
				}
				else if(map[ni][nj]=='#')continue; // 벽
				else if(map[ni][nj]>='A'&&map[ni][nj]<='F') {
					int door = 1<<(map[ni][nj]-'A');
					if((p.key&door)>0) { //키를 가지고 있음
						visited[p.key][ni][nj] = true;
						q.offer(new point(ni,nj,p.m+1,p.key));
					}
				}else if(map[ni][nj]>='a'&&map[ni][nj]<='f') {
					int k = 1<<(map[ni][nj] - 'a');
					k = k | p.key; //키 챙기기
					if(!visited[k][ni][nj]) {
						visited[k][ni][nj] = true;
						visited[p.key][ni][nj] = true;
						q.offer(new point(ni,nj,p.m+1, k));
					}
				}else { //점이나 시작위치
					visited[p.key][ni][nj] = true;
					q.offer(new point(ni,nj,p.m+1, p.key));
				}
				
				
			}
		}
		
		return result;
	}

}
