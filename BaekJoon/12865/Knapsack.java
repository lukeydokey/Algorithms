package day2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*

백준 12865 평범한 배낭

 */

public class Knapsack {

	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); // 물품의 수
		int K = Integer.parseInt(st.nextToken()); // 배낭의 무게
		
		int [] maxV = new int[K+1]; //배낭 무게 당 최대 가치합
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int w = Integer.parseInt(st.nextToken()); //물건의 무게
			int v = Integer.parseInt(st.nextToken()); //물건의 가치
			
			for(int j=K;j-w>=0;j--) {
				maxV[j] = Math.max(maxV[j], v+ maxV[j-w]);
			}
			
		}
	    
		bw.write(maxV[K]+"");
		bw.flush();
		bw.close();
		
		
	}

}
