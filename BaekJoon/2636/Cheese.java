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

백준 2636 치즈

 */

public class Cheese {
	
	
	static int[][] map;
	static boolean[][] visited;
	static int[][] del = {
			{0, 1},
			{1, 0},
			{0, -1},
			{-1, 0}
	};
	static int time, lastcheese, n, m, cnt;
	public static void main(String[] args) throws IOException{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	    
	    n = Integer.parseInt(st.nextToken());
	    m = Integer.parseInt(st.nextToken());
	    
	    map = new int[n][m];
	    cnt = 0;
	    for(int i=0;i<n;i++) {
	    	st = new StringTokenizer(br.readLine(), " ");
	    	for(int j=0;j<m;j++) {
	    		int cur = Integer.parseInt(st.nextToken());
	    		map[i][j] = cur; //치즈 맵 입력
	    		if(cur==1)
	    			cnt++;
	    	}
	    }
	    
	    while(cnt!=0) {
	    	time++;
	    	lastcheese = cnt;
	    	bfs();
	    }
	    
		bw.write(String.format("%d\n%d", time, lastcheese));
		bw.flush();
		bw.close();
		
	}
	
	static void bfs() {
		
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] { 0, 0 });
		visited = new boolean[n][m];
		visited[0][0] = true;
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			for (int d = 0; d < 4; d++) {
				int ni = cur[0] + del[d][0];
				int nj = cur[1] + del[d][1];
				if (ni < 0 || ni >= n || nj < 0 || nj >= m || visited[ni][nj]) continue; //방문한 곳 거르기
				if (map[ni][nj] == 1) { //방문하지 않은 치즈 = 테두리
					cnt--;
					map[ni][nj] = 0;
				} else if (map[ni][nj] == 0) {
					q.offer(new int[] { ni, nj });
				}
				visited[ni][nj] = true; //방문 체크
			}
		}
		
	}
	
}
