package ssafy.com.algo13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*

백준 3985 롤케이크

 */

public class RollCake {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int L = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		
		int wantMax = 0;
		int receivedMax = 0;
		int wantMaxIdx = 0;
		int maxIdx=0;
		int [] cake = new int[L+1];
		for(int i=1;i<=N;i++) {
			String[] line = br.readLine().split(" ");
			int start = Integer.parseInt(line[0]);
			int end = Integer.parseInt(line[1]);
			if(wantMax < end-start) {
				wantMax = end-start;
				wantMaxIdx = i;
			}
			
			int cnt = 0;
			for(int j=start;j<=end;j++) {
				if(cake[j]==0) {
					cake[j]=i;
					cnt++;
				}
			}
			if(cnt>receivedMax) {
				receivedMax = cnt;
				maxIdx = i;
			}
		}
		
		System.out.println(wantMaxIdx);
		System.out.println(maxIdx);
		
	}

}
