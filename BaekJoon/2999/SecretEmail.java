package ssafy.com.algo11;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*

백준 2999번 비밀 이메일

 */

public class SecretEmail {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int N, R, C;
	public static void main(String[] args) throws IOException{
		String pass = br.readLine();
		
		N = pass.length();
		func(N); //R과 C 구하기
		
		char[][] tmp = new char[R][C];
		int cnt = 0;
		for(int i=0;i<C;i++) {
			for(int j=0;j<R;j++) {
				tmp[j][i] = pass.charAt(cnt++);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				sb.append(tmp[i][j]);
			}
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
	static void func(int n) {
		int sqrt = (int) Math.sqrt(n);
		
		for(int i=1;i<=sqrt;i++) {
			if(n%i==0) {
				R = i;
				C = n/i;
			}
		}
	}
}
