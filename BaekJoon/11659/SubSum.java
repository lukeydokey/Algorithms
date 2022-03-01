package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*

백준 11659 구간 합 구하기 4

 */

public class SubSum {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n =Integer.parseInt(st.nextToken());
		int m =Integer.parseInt(st.nextToken());
		
		int[] nums = new int[n];
		int[] sums = new int[n];
		st = new StringTokenizer(br.readLine(),  " ");
		for(int i=0;i<n;i++) {
			nums[i] = Integer.parseInt(st.nextToken());
			if(i==0) {
				sums[i] = nums[i];
			}
			else {
				sums[i] = sums[i-1] + nums[i];
			}
		}
		
		for(int i=0;i<m;i++) { // m번 부분 합을 구함
			st = new StringTokenizer(br.readLine(), " " );
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			
			if(a>0) {
				bw.write(sums[b]-sums[a-1]+"\n");
			}else {
				bw.write(sums[b]+"\n");
			}
		}
		bw.flush();
		bw.close();
		
	}

}
