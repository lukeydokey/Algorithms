package day9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*

백준 16948번 데스 나이트

 */

public class DeathKnight {
	static int N;
	static int[][] del = {
			{-2, -1},
			{-2, 1},
			{0, -2},
			{0, 2},
			{2, -1},
			{2, 1}
	};
	public static void main(String[] args) throws IOException{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		boolean [][] visited = new boolean[N][N];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int sr = Integer.parseInt(st.nextToken()); //출발 r
		int sc = Integer.parseInt(st.nextToken()); //도착 c
		int ar = Integer.parseInt(st.nextToken()); //도착 r
		int ac = Integer.parseInt(st.nextToken()); //도착 c
		
		int cnt = -1;
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {sr, sc, 0});
		visited[sr][sc] = true;
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			
			int curR = cur[0];
			int curC = cur[1];
			int curMove = cur[2];
			
			if(curR==ar&&curC==ac) {
				cnt = curMove;
				break;
			}
			
			for(int d=0;d<6;d++) {
				int nr = curR + del[d][0];
				int nc = curC + del[d][1];
				
				if(nr<0||nr>=N||nc<0||nc>=N||visited[nr][nc]) continue;
				
				q.offer(new int[] {nr,nc,curMove+1});
				visited[nr][nc]=true;
				
			}
			
			
		}
		
		System.out.println(cnt);
	}

}
