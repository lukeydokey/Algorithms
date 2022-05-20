package p0520;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/*

백준 6603 로또

 */

public class Lotto {
	
	static StringBuilder sb;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));
		
		while(true) {
			String[] input = br.readLine().split(" ");
			if(Integer.parseInt(input[0])==0) // 마지막 입력은 0
				break;
			int n = Integer.parseInt(input[0]);
			int[] set = new int[n];
			for(int i=1;i<=n;i++) {
				set[i-1] = Integer.parseInt(input[i]);
			}
			Arrays.sort(set);
			
			sb = new StringBuilder();
			comb(set, new int[6], 0, 0, 6);
			
			bw.write(sb.toString()+"\n");
		}
		bw.flush();
		bw.close();
	}
	static void comb(int[] nums, int[] order, int cnt, int start, int n){
		if(cnt==n) {
			for(int i=0;i<n;i++) {
				sb.append(order[i]).append(" ");
			}
			sb.append("\n");
		}else {
			for(int i=start;i<nums.length;i++) {
				order[cnt] = nums[i];
				comb(nums, order, cnt+1, i+1, n);
			}
		}
	}
}
