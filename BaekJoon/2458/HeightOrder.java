package day6;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*

백준 2458 키 순서

 */

public class Main {
	static int N, M, sCnt, tCnt;
	static int[][] adj;
	public static void main(String[] args) throws IOException{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
        
		adj = new int[N][N];
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			// a < b
			
			adj[a][b] = 1;
		}
		
		int cnt = 0;
		for(int i=0;i<N;i++) {
			if(knowOrder(i))
				cnt++;
		}
        bw.write(String.format("%d", cnt));
		
		bw.flush();
		bw.close();
	}
	static boolean knowOrder(int s) {
		//학생이 키 순서를 알 수 있는지 체크하는 메서드
		sCnt = 0;
		tCnt = 0;
		
		countSmall(s, new boolean[N]);
		countTall(s, new boolean[N]);
		
		if(sCnt+tCnt == N-1)
			return true;
		else
			return false;
	}
	static void countSmall(int a, boolean[] visited) {
		visited[a]=true;
		for(int i=0;i<N;i++) {
			if(!visited[i]&&adj[i][a]==1) {
				countSmall(i, visited);
				sCnt++;
			}
		}
	}
	static void countTall(int a, boolean[] visited) {
		visited[a]=true;
		for(int i=0;i<N;i++) {
			if(!visited[i]&&adj[a][i]==1) {
				countTall(i, visited);
				tCnt++;
			}
		}
	}
}