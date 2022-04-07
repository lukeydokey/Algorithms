package day7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*

백준 1939 중량제한

 */

public class WeightRestriction {
	static class Bridge {
		int i, r;

		public Bridge(int island, int restriction) { // 섬 i까지 
			i = island;
			r = restriction;
		}
	}
	
	static int N, M, start, end;
	static ArrayList<Bridge>[] list;
	static boolean[] visited;
	public static void main(String[] args) throws IOException{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken());
			// a - b 다리 무게제한 c

			list[a].add(new Bridge(b, c));
			list[b].add(new Bridge(a, c));
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		start = Integer.parseInt(st.nextToken()) - 1;
		end = Integer.parseInt(st.nextToken()) - 1;
		
		int low = 0;
		int high = 1000000000;
		while(low <= high) {
            visited = new boolean[N+1];
            int mid =(low+high)/2;
            if(func(mid))
                low = mid+1;
            else
                high = mid-1;
        }
		
		bw.write(high+"");
		bw.flush();
		bw.close();
	}
	static boolean func(int weight) {
		Queue<Integer> q = new LinkedList<>();
		visited[start] = true;
		q.offer(start);
		while(!q.isEmpty()) {
			int island = q.poll();
			if(island==end)
				return true;
			
			for(Bridge b : list[island]) {
				if(!visited[b.i] && weight <= b.r) {
					visited[b.i] = true;
					q.offer(b.i);
				}
			}
		}
		
		return false;
	}
}
