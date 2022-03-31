package day2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*

백준 1149 RGB 거리

 */

public class RGBStreet {

	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int [] minP = new int[3];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			int tmpR = minP[0]; // N-1번째 집 R로 색칠
			int tmpG = minP[1]; // N-1번째 집 G로 색칠
			int tmpB = minP[2]; // N-1번째 집 B로 색칠
			
			minP[0] = Math.min(r + tmpG, r + tmpB);
			minP[1] = Math.min(g + tmpR, g + tmpB);
			minP[2] = Math.min(b + tmpR, b + tmpG);
		}
		
		int result = Math.min(minP[0], minP[1]);
		result = Math.min(result, minP[2]);
		bw.write(result+"");
		bw.flush();
		bw.close();
		
	}

}
