package ssafy.com.algo9;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*

백준 6236번 용돈 관리

 */


public class MoneyManagement {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int max = 0; 
    static int min = Integer.MAX_VALUE;
    
	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int [] arr = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(br.readLine());
			if(max<arr[i]) {
				max = arr[i];
			}
			if(min>arr[i]) {
				min = arr[i];
			}
		}
		
		int result = func(arr, n, m);
		
		bw.write(result+"");
		bw.flush();
		bw.close();
	}
	
	static int func(int[] arr, int n, int m) {
		if(n==1) {
			return arr[0];
		}
		else {
			int lo = min; // 최소사용금액
			int hi = max*n; //최고사용금액 * 일자
			int ans = hi;
			
			while(lo<=hi) {
				int mid = (lo+hi)>>1;
				if(check(arr,mid,n,m)) {
					hi = mid-1;
					ans = Math.min(ans, mid);
				}else {
					lo = mid+1;
				}
			
			}
		
			return ans;
		}
	}
	
	static boolean check(int[]arr, int money, int n, int m) {
		int tmp = money;
		int cnt = 1;
		
		for(int i=0;i<n;i++) {
			if(money<arr[i]) return false;
			
			if(tmp - arr[i]<0) { // 돈이 부족
				tmp = money; //새로 인출
				cnt++;
			}
			
			tmp -= arr[i]; //돈이 안부족함
		}
		
		return cnt<=m;
	}
}