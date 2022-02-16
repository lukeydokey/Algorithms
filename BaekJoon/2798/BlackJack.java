package ssafy.com.algo10;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*

백준 2798 블랙잭

*/

public class BlackJack {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int[] nums;
	static int min, n, m;
	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		nums = new int[n];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0;i<n;i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		func(0,0,0);
		
		bw.write(min+"");
		bw.flush();
		bw.close();
		
	}
	static void func(int cnt, int start, int sum) {
		if(cnt==3) {
			if(sum>min&&sum<=m) {
				min = sum;
			}
		}else {
			for(int i=start;i<n;i++) {
				func(cnt+1,i+1,sum+nums[i]);
			}
		}
	}
}
