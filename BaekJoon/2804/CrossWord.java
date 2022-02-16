package ssafy.com.algo10;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*

백준 2804 크로스워드

 */

public class CrossWord {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(br.readLine(), " ");
		
		String a = st.nextToken();
		String b = st.nextToken();
		int n = a.length();
		int m = b.length();
		
		int [] idx = new int[2]; //크로스 하는 부분 인덱스
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(a.charAt(i)==b.charAt(j)) { // 겹치는 곳 찾음
					if(idx[0]==0&&idx[1]==0) { // 최초값일때만
						idx[0] = i;
						idx[1] = j;
					}
				}
			}
		}
		
		
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				if(i==idx[1]) { //겹치는 줄 가로
					bw.write(a.charAt(j));
				}else if(j==idx[0]) {
					bw.write(b.charAt(i));
				}else {
					bw.write(".");
				}
			}
			bw.write("\n");
		}
		
		bw.flush();
		bw.close();
	}

}
