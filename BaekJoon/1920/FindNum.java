package ssafy.com.algo9;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/*

백준 1920 수 찾기

 */


public class FindNum {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int[] nums;
	public static void main(String[] args) throws IOException{
		int n = Integer.parseInt(br.readLine());
		
		st=new StringTokenizer(br.readLine(), " ");
		nums = new int[n];
		for(int i=0;i<n;i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(nums);
		
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0;i<m;i++) {
			int x = Integer.parseInt(st.nextToken());
			bw.write(String.format("%d\n", func(nums, x)));
		}
		
		bw.flush();
		bw.close();
	}
	
	static int func(int[] nums, int x) {
		int start = 0;
		int end = nums.length-1;
		
		while(start<=end) {
			int mid = (start+end)>>1;
			
			if(nums[mid]==x) {
				return 1;
			}else if(nums[mid]>x) {
				end = mid-1;
			}else {
				start = mid+1;
			}
		}
		
		
		return 0;
	}
}
