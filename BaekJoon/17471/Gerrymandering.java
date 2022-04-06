package day6;

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

백준 17471 게리맨더링

 */

public class Gerrymandering {
	static int[] population, area;
	static int[][] map;
	static int N, minDiff;
	static ArrayList<Integer> area1 = new ArrayList<>();
	static ArrayList<Integer> area2 = new ArrayList<>();
	public static void main(String[] args) throws IOException{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		
		population = new int[N];
		area = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=0;i<N;i++) {
			population[i] = Integer.parseInt(st.nextToken());
		}
		
		map = new int[N][N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			for(int j=0;j<a;j++) {
				int tmp = Integer.parseInt(st.nextToken()) - 1;
				map[i][tmp] = 1;
				map[tmp][i] = 1;
			}
		}
		
		minDiff = Integer.MAX_VALUE;
		func(0, 0);
		
		if(minDiff!=Integer.MAX_VALUE)
			bw.write(minDiff+"");
		else
			bw.write(-1+"");
		bw.flush();
		bw.close();
	}
	static void func(int cnt, int start) {
		if(cnt==N) {
			if(area1.size()==0||area2.size()==0)
				return;
			if(!isLinked(1)||!isLinked(2)) {
				return;
			}
			
			int sum1=0;
			for(int a : area1) {
				sum1+=population[a];
			}
			int sum2=0;
			for(int a : area2) {
				sum2+=population[a];
			}
			
			minDiff = Math.min(minDiff, Math.abs(sum1-sum2));
			
		}else {
			for(int i=start;i<N;i++) {
				area1.add(i);
				func(cnt+1,i+1);
				area1.remove(area1.size()-1);
				
				area2.add(i);
				func(cnt+1,i+1);
				area2.remove(area2.size()-1);
			}
		}
	}
	static boolean isLinked(int area) {
		if(area==1) { //구역 1
			int parent = area1.get(0);
			for(int i=1;i<area1.size();i++) {
				if(map[area1.get(i)][parent]==1)continue; // 직접 연결됨
				Queue<Integer> q = new LinkedList<>();
				boolean[]visited = new boolean[N];
				q.offer(area1.get(i));
				visited[area1.get(i)]=true;
				boolean find = false;
				outer : while(!q.isEmpty()) {
					int cur = q.poll();
					
					for(int j=0;j<N;j++) {
						if(!visited[j]&&map[cur][j]==1&&!area2.contains(j)) {
							if(map[j][parent]==1) {
								find=true;
								break outer;
							}
							q.offer(j);
							visited[j]=true;
						}
					}
				}
				if(!find)
					return false;
			}
		}else { //구역 2
			int parent = area2.get(0);
			for(int i=1;i<area2.size();i++) {
				if(map[area2.get(i)][parent]==1)continue; // 직접 연결됨
				Queue<Integer> q = new LinkedList<>();
				boolean[]visited = new boolean[N];
				q.offer(area2.get(i));
				visited[area2.get(i)]=true;
				boolean find = false;
				outer : while(!q.isEmpty()) {
					int cur = q.poll();
					
					for(int j=0;j<N;j++) {
						if(!visited[j]&&map[cur][j]==1&&!area1.contains(j)) {
							if(map[j][parent]==1) {
								find=true;
								break outer;
							}
							q.offer(j);
							visited[j]=true;
						}
					}
				}
				if(!find)
					return false;
			}
		}
		
		
		return true;
	}
}
