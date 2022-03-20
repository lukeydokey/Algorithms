package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*

백준 20040 사이클 게임

 */

public class CycleGame {
	static int[] parents;
	
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		parents = new int[N];
		for(int i=0;i<N;i++) {
			parents[i] = i;
		}
		
		
		boolean flag = false; //사이클이 만들어졌는지 체크
		int result = 0;
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(!flag&&!(union(a,b))) {
				flag = true;
				result = i+1;
				break;
			}
			
		}
		
		bw.write(result+"");
		bw.flush();
		bw.close();
		
		
	}
	
	static int find(int a) {
		if(parents[a]==a) return a;
		return parents[a] = find(parents[a]);
	}
	
	static boolean union(int a, int b) {
		int ap = find(a);
		int bp = find(b);
		
		if(ap==bp) return false; // 이미 같은 집단
		
		parents[bp] = ap;
		
		return true;
	}
}
