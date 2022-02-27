package ssafy.com.algo16;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*

백준 1753번 최단 경로

 */

public class MinPath {
	
	static class Edge implements Comparable<Edge>{
		int v, d;

		public Edge(int v, int d) {
			super();
			this.v = v;
			this.d = d;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(d, o.d);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		int[] distance = new int[V];
		boolean[] visited = new boolean[V];
		ArrayList<Edge>[] list = new ArrayList[V];
		for(int i=0;i<V;i++) {
			list[i] = new ArrayList<>();
		}
		
		int start = Integer.parseInt(br.readLine()) - 1; // 시작 정점
		
		for(int i=0;i<E;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			int d = Integer.parseInt(st.nextToken());
			
			list[a].add(new Edge(b, d)); // a->b 가중치 d
		}
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[start] = 0; // 시작정점 거리는 0
		pq.offer(new Edge(start, 0));
		
		int cnt = 0;
		while(!pq.isEmpty()) {
			Edge edge = pq.poll();
			
			if(visited[edge.v]) continue;
			
			visited[edge.v] = true;
			
			//모든 정점 거리 선택 완료
			if(++cnt == V)break;
			
			for(Edge e : list[edge.v]) {
				if(!visited[e.v] &&
						distance[e.v] > edge.d+e.d) {
					distance[e.v] = edge.d + e.d;
					e.d += edge.d;
					pq.offer(e);
				}
			}
			
		}
		
		for(int d : distance) {
			if(d!=Integer.MAX_VALUE)
				bw.write(d+"\n");
			else
				bw.write("INF\n");
		}
		
		bw.flush();
		bw.close();
	}

}
