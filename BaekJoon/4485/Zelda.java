package day3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


/*

백준 4485 녹색 옷 입은 애가 젤다지?

 */

public class Zelda {
	
	static class point implements Comparable<point>{
		int i, j, coin;

		public point(int i, int j, int coin) {
			super();
			this.i = i;
			this.j = j;
			this.coin = coin;
		}

		@Override
		public int compareTo(point o) {
			return Integer.compare(coin, o.coin);
		}
	}
	
	static int[][] del = {
			{0, 1},
			{1, 0},
			{0, -1},
			{-1, 0}
	};
	
	public static void main(String[] args) throws IOException{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringTokenizer st;
		
	    int t=1;
		while(true) {
			int N = Integer.parseInt(br.readLine());
			if(N==0)break;
			
			int [][] map = new int[N][N];
			int [][] minCoin = new int[N][N];
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j=0;j<N;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i=0;i<N;i++)
				Arrays.fill(minCoin[i], Integer.MAX_VALUE);
			int result = function(map, minCoin, N);
			
			bw.write(String.format("Problem %d: %d\n", t++, result));
		}
		
		bw.flush();
		bw.close();
		
	}
	static int function(int[][] map, int[][] minCoin, int N) {
		int sum = 0;
		Queue<point> q = new LinkedList<>();
		q.offer(new point(0,0,map[0][0]));
		minCoin[0][0] = map[0][0];
		
		while(!q.isEmpty()) {
			point p = q.poll();
			
			for(int d=0;d<4;d++) {
				int ni = p.i + del[d][0];
				int nj = p.j + del[d][1];
				
				if(ni>=0&&ni<N&&nj>=0&&nj<N
						&&minCoin[ni][nj]>minCoin[p.i][p.j]+map[ni][nj]) { //이동할 지점 코인 최소개수보다 더 작음
					minCoin[ni][nj] = minCoin[p.i][p.j]+map[ni][nj];
					q.offer(new point(ni,nj,p.coin+map[ni][nj]));
				}
			}
		}
		
		sum = minCoin[N-1][N-1];
		
		return sum;
	}
}
