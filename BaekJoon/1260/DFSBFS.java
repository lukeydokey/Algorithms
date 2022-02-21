package ssafy.com.algo13;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*

백준 1260 DFS와 BFS

 */

public class DFSBFS {
	static int N, M, V;
	static int[][] adjMatrix;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		//정점 개수
		N = Integer.parseInt(st.nextToken());
		//간선 개수
		M = Integer.parseInt(st.nextToken());
		//시작 정점
		V = Integer.parseInt(st.nextToken());
		
		adjMatrix = new int[N+1][N+1];
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			//정점 A
			int a = Integer.parseInt(st.nextToken());
			//정점 B
			int b = Integer.parseInt(st.nextToken());
			
			//간선
			adjMatrix[a][b] = 1;
			adjMatrix[b][a] = 1;
		}
		
		dfs(adjMatrix, new boolean[N+1], V);
		sb.append("\n");
		bfs(adjMatrix, V);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
	}
	
	static void dfs(int[][] adjMatrix, boolean[] visited, int cur) {
		
		visited[cur] = true;
		sb.append(cur+" ");
		
		for(int i=1;i<=N;i++) {
			if(!visited[i]&&adjMatrix[cur][i]!=0) {
				dfs(adjMatrix, visited, i);
			}
		}
		
	}
	
	static void bfs(int[][] adjMatrix, int start) {
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[N+1];
		
		visited[start] = true;
		queue.offer(start);
		
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			sb.append(cur+" ");
			
			for (int i = 1; i <= N; i++) {
				if (!visited[i] && adjMatrix[cur][i] != 0) {
					queue.offer(i);
					visited[i]=true;
				}
			}
			
		}
		
	}
}
