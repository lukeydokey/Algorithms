package ssafy.com.algo15;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*

백준 15686 치킨 배달

 */

public class Chicken {
	
	static class Point {
		int x, y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	
	static int N, M;
	static ArrayList<Point> chicken = new ArrayList<>();
	static ArrayList<Point> house = new ArrayList<>();
	static int dMin;
	static boolean[] selected;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0;j<N;j++) {
				int a = Integer.parseInt(st.nextToken());
				if (a==1) {
					house.add(new Point(i, j));
				}else if(a==2) {
					chicken.add(new Point(i,j));
				}
			}
		}
		
		dMin = Integer.MAX_VALUE;
		selected = new boolean[chicken.size()];
		dfs(0,0);
		
		bw.write(dMin+"");
		bw.flush();
		bw.close();
		
	}
	static void dfs(int depth, int start) {
		if(depth==M) { // 치킨집 M개 선택
			
			int dSum = 0;// 집들의 치킨거리 합
			for(int i=0;i<house.size();i++) {
				Point p = house.get(i);
				int min = Integer.MAX_VALUE;
				for(int j=0;j<chicken.size();j++) {
					if(selected[j]) { // 폐업되지 않은 치킨집
						Point cp = chicken.get(j); // 치킨집 위치
						min = Math.min(min, Math.abs(p.x - cp.x) + Math.abs(p.y - cp.y)); // 집에서 치킨집까지 거리들 중 가장 짧은 거리
					}
				}
				dSum += min; // 치킨거리 합함
			}
			
			dMin = Math.min(dMin, dSum);
			
		}else {
			for(int i=start;i<chicken.size();i++) {
				selected[i] = true;
				dfs(depth+1, i+1);
				selected[i] = false;
			}
		}
	}
}
