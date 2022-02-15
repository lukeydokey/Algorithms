package ssafy.com.algo9;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*

백준 1074번 Z

 */


public class Z {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int cnt;
	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		func(r, c, n);
		
		bw.write(String.format("%d", cnt));
		bw.flush();
		bw.close();
		
	}
	
	static void func(int i, int j, int n) {
		
		if(n==1) {
			for(int x=0;x<2;x++) {
				for(int y=0;y<2;y++) { // 2X2에서 위치만큼 카운트+
					if(x==i&&y==j) {
						cnt += i*2+j;
					}
				}
			}
		}else {
			int half = (int)Math.pow(2, n)/2;
			
			// 4분할
			if (i < half && j < half) { //좌상
				func(i, j, n-1);
			} else if (i < half && j >= half) { //우상
				cnt += half*half;
				func(i, j-half, n-1);
			} else if (j < half) { //좌하
				cnt += half*half*2;
				func(i-half, j, n-1);
			} else { //우하
				cnt += half*half*3;
				func(i-half,j-half,n-1);
			}
		}
	}
}
