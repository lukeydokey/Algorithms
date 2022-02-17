package ssafy.com.algo11;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*

백준 9663 N-Queen

 */

public class NQueenBackTrackingTest {
	
	static int N , ans;
	static int[] col;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		col = new int[N+1];
		ans = 0;
		
		setQueen(1);
		
		bw.write(ans+"");
		bw.flush();
		bw.close();
	}
	
	public static void setQueen(int rowNo) { //rowNo는 현재 퀸을 두어야 하는 행
		
		if(!isAvailable(rowNo-1)) return; //직전까지의 상황이 유망하지않다면 리턴
		
		//기본 파트 : 퀸을 모두 놓았다면 
		if(rowNo>N) {
			ans++;
			return;
		}
		
		//1열부터 - n열까지 퀸을 놓는 시도
		for(int i=1;i<=N;i++) {
			col[rowNo] = i;
			setQueen(rowNo+1);
		}
	}
	
	public static boolean isAvailable(int rowNo) {
		
		for(int i=1;i<rowNo;i++) {
			if(col[rowNo] == col[i] || rowNo-i == Math.abs(col[rowNo]-col[i])) { 
				return false;
			}
		}
		return true;
	}
}
