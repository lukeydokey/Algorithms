package p0417;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*

백준 7569 토마토

 */

public class Tomato {
	static int M, N, H;
	static int[][][] map;
	static boolean[][][] visited;
	static StringTokenizer st;
	static int[] dx = {0,0,1,-1,0,0};
	static int[] dy = {1,-1,0,0,0,0};
	static int[] dz = {0,0,0,0,1,-1};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new int [H][N][M];
		visited = new boolean [H][N][M];
		
		Queue<int[]> q = new LinkedList<>();
		int tCnt = 0; //토마토 카운트
		for(int k=0;k<H;k++) {
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j=0;j<M;j++) {
					map[k][i][j]=Integer.parseInt(st.nextToken());
					if(map[k][i][j]==-1)continue;
					else if(map[k][i][j]==1) {
						q.offer(new int[] {k, i, j, 0}); //익은 토마토 큐에 삽입
						visited[k][i][j]=true;
					}
					tCnt++;
				}
			}
		}
		
		int day = 0;
		while(!q.isEmpty()) {
			int[] t = q.poll();
			int curk = t[0];
			int curi = t[1];
			int curj = t[2];
			int curDay = t[3];
			
			tCnt--; // 토마토 익으면 cnt--
			day = Math.max(day, curDay);
			
			for(int d=0;d<6;d++) {
				int nk = curk + dz[d];
				int ni = curi + dy[d];
				int nj = curj + dx[d];
				
				if(ni<0||ni>=N||nj<0||nj>=M||nk<0||nk>=H||visited[nk][ni][nj]||map[nk][ni][nj]==-1)continue;
				
				q.offer(new int[] {nk, ni, nj, curDay+1});
				visited[nk][ni][nj]=true;
			}
			
		}
		
		if(tCnt==0) {
			System.out.println(day);
		}else {
			System.out.println(-1);
		}
		
	}

}
