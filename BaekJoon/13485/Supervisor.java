package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*

백준 13458 시험 감독

 */

public class Supervisor {

	public static void main(String[] args) throws IOException{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		
		int [] room = new int [N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=0;i<N;i++) {
			room[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		int head = Integer.parseInt(st.nextToken());
		int sub = Integer.parseInt(st.nextToken());
		
		long result = N;
		for(int i=0;i<N;i++) {
			if(room[i]-head<=0)continue;
			result += (room[i] - head) / sub;
			if((room[i]-head)%sub!=0) result++;
		}
		
		bw.write(result+"");
		bw.flush();
		bw.close();
		
	}

}
