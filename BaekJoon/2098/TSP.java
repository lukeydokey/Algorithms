package p0417;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*

백준 2098 외판원 순회

 */

public class TSP {
	static int N;
	static int[][] cost;
	static int[][] dp;
	static final int INF = 9999999;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		cost = new int[N][N];
		dp = new int[N][(1<<N)-1];
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j=0;j<N;j++) {
				cost[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0;i<N;i++) {
			Arrays.fill(dp[i], INF);
		}
		
		System.out.println(func(0,1));
	}
	
	static int func(int cur,int visited) {
		if(visited == (1<<N) - 1) {
			if(cost[cur][0]==0) {
				return INF;
			}
			
			return cost[cur][0];
		}
		else if(dp[cur][visited]!=INF) {
			return dp[cur][visited];
		}
		else {
			for(int i=0;i<N;i++) {
				if((visited & (1<<i))==0 && cost[cur][i]!=0) {
					dp[cur][visited] = Math.min(dp[cur][visited], func(i, visited | (1<<i)) + cost[cur][i]);
				}
			}
			return dp[cur][visited];
		}
	}
}
