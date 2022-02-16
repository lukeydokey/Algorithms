package ssafy.com.algo10;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*

백준 1992 쿼드트리

 */

public class QuadTree {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int n;
	static int[][] data;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		n = Integer.parseInt(br.readLine());
		
		data = new int [n][n];
		for(int i=0;i<n;i++) {
			String[] line = br.readLine().split("");
			for(int j=0;j<n;j++) {
				data[i][j] = Integer.parseInt(line[j]); //데이터 배열 저장
			}
		}
		
		//쿼드트리압축연산
		func(0,0,n);
		//sb출력
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	static void func(int si, int sj, int n) {
		//시작 점의 상태
		int start = data[si][sj];
		boolean diff = checkDiff(si,sj,n,start); // 원소가 다른게 있는지 체크
		if(n<=2) { //2X2일때, 1x1일때
			
			if(diff) {// 전부 같지 않을 때
				sb.append("(");
				for(int i=si;i<si+n;i++) {
					for(int j=sj;j<sj+n;j++) {
						sb.append(data[i][j]); // 다 덧붙여준다.
					}
				}
				sb.append(")");
			}else { // 전부 같을 때
				sb.append(start);
			}
		}
		else { // 2X2보다 클 때
			int half = n>>1; //길이의 절반
			
			if(diff) { // 다른 원소가 있을 때
				sb.append("(");
				func(si,sj,half); //좌상
				func(si,sj+half,half); //우상
				func(si+half,sj,half); //좌하
				func(si+half,sj+half,half); //우하
				sb.append(")");
			}else { // 전부 같을 때
				sb.append(start);
			}
		}
	}
	
	static boolean checkDiff(int si, int sj, int n, int start) { //다른 원소가 있는지 체크
		for(int i=si;i<si+n;i++) { // 탐색
			for(int j=sj;j<sj+n;j++) {
				if(data[i][j]!=start) {
					return true;
				}
			}
		}
		
		return false;
	}
}
