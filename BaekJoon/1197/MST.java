package ssafy.com.algo14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*

백준 1197 최소 스패닝 트리

 */

public class MST {
	
	static class Edge implements Comparable<Edge>{
		int v, d;
		
		public Edge(int vertex, int distance) { //정점 v까지 이동하는데 걸리는 길이 저장
			v = vertex;
			d = distance;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(d, o.d);
		}
		
		
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		boolean [] visited = new boolean[V];
		int [] distance = new int[V];
		ArrayList<Edge>[] list = new ArrayList[V];
		for(int i=0;i<V;i++) {
			list[i] = new ArrayList<>();
			distance[i] = Integer.MAX_VALUE;
		}
		
		for(int i=0;i<E;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken());
			// a - b 간선 가중치 c
			
			list[a].add(new Edge(b, c));
			list[b].add(new Edge(a, c));
		}
		
		
		int result = 0; // MST 비용
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		
		distance[0] = 0;
		pq.offer(new Edge(0, 0));
		
		int cnt = 0;
		while(true) {
			Edge edge = pq.poll();
			
			if(visited[edge.v])continue; // 이미 방문한 정점
			
			visited[edge.v] = true;
			result += edge.d;
			
			//모든 정점 방문
			if(++cnt==V) {
				break;
			}
			
			for(Edge e : list[edge.v]) {
				if(!visited[e.v] &&
						distance[e.v]>e.d) {
					distance[e.v] = e.d;
					pq.offer(e);
				}
			}
			
		}
		
		System.out.println(result);
	}

}
