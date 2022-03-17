package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*

백준 9205 맥주 마시면서 걸어가기

*/

public class BeerAndWalk {

	public static void main(String[] args) throws IOException{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int t=0;t<T;t++) {
			
			int n = Integer.parseInt(br.readLine());
			
			st = new StringTokenizer(br.readLine(), " ");
			int hx = Integer.parseInt(st.nextToken()); //집
			int hy = Integer.parseInt(st.nextToken());
			
			int[][] cvs = new int[n][2];
			for(int i=0;i<n;i++) {
				st = new StringTokenizer(br.readLine(), " ");
				cvs[i][0] = Integer.parseInt(st.nextToken()); //편의점 위치
				cvs[i][1] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine(), " ");
			int fx = Integer.parseInt(st.nextToken()); //페스티벌 위치
			int fy = Integer.parseInt(st.nextToken());
			
			if(bfs(hx, hy, cvs, fx, fy)) {
				bw.write("happy\n");
			}else {
				bw.write("sad\n");
			}
			
			
		}
		
		bw.flush();
		bw.close();
		
	}
	static boolean bfs(int hx, int hy, int[][] cvs, int fx, int fy) {
		
		if(calDis(hx,hy,fx,fy)<=1000) return true;
		
		Queue<int[]> q = new LinkedList<>();
		boolean[] visited = new boolean[cvs.length];
		for(int i=0;i<cvs.length;i++) {
			if(calDis(hx,hy,cvs[i][0],cvs[i][1])<=1000) q.offer(new int[] {cvs[i][0], cvs[i][1], i});
		}
		
		while(!q.isEmpty()) {
			int[] info = q.poll();
			int cx = info[0]; //현재 x
			int cy = info[1]; //현재 y
			int cur = info[2]; //현재 편의점 번호
			
			if(visited[cur]) continue; //지나온 편의점
			
			visited[cur] = true;
			
			if(calDis(cx,cy,fx,fy)<=1000) return true; //페스티벌 도착가능
			else {
				for(int i=0;i<cvs.length;i++) {
					if(!visited[i]) {
						if(calDis(cx,cy,cvs[i][0],cvs[i][1])<=1000) q.offer(new int[] {cvs[i][0], cvs[i][1], i});
					}
				}
			}
		}
		
		return false;
	}
	static int calDis(int x1, int y1, int x2, int y2) {
		return Math.abs(x1-x2) + Math.abs(y1-y2);
	}
}
