/*
 백준 1003번 피보나치 함수
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static int [][] dp = new int[41][2]; 
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		
		dp[0][0] = 1;
		dp[0][1] = 0;
		dp[1][0] = 0;
		dp[1][1] = 1;
		
		for(int i=0;i<T;i++) {
			int n = Integer.parseInt(br.readLine());
			fib(n);
			
			bw.write(String.format("%d %d\n", dp[n][0], dp[n][1]));
		}
		bw.flush();
		bw.close();
	}
	
	static int[] fib(int n) {
		if(dp[n][0] == 0 && dp[n][1] == 0) {
			dp[n][0] = fib(n-1)[0] + fib(n-2)[0];
			dp[n][1] = fib(n-1)[1] + fib(n-2)[1];
		}
		
		return dp[n];
	}
}