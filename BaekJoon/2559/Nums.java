package ssafy.com.algo10;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*

백준 2559 수열

 */

public class Nums {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException{
		st =new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int [] temper = new int[n];
		st= new StringTokenizer(br.readLine(), " ");
		for(int i=0;i<n;i++) {
			temper[i] = Integer.parseInt(st.nextToken()); // n일간의 온도 저장
		}
		
		int max = Integer.MIN_VALUE;
		for(int i=0;i<n-(k-1);i++) {
			int sum =0;
			for(int j=i;j<i+k;j++) {
				sum += temper[j];
			}
			if(max<sum) {
				max = sum;
			}
		}
		
		bw.write(max+"");
		bw.flush();
		bw.close();
	}

}
