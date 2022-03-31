package day2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*

백준 1463 1로 만들기

 */

public class One {

	public static void main(String[] args) throws IOException{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[] d = new int[N+1];
		d[0] = 0;
		d[1] = 0;
		for(int i=2;i<=N;i++) {
			d[i] = d[i-1] + 1;
			if(i%2==0) d[i] = Math.min(d[i], d[i/2]+1);
			if(i%3==0) d[i] = Math.min(d[i], d[i/3]+1);
		}
		
		
		bw.write(d[N]+"");
		bw.flush();
		bw.close();
	}

}
