package p0417;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


/*

백준 4095 최대 정사각형

 */

public class BigSquare {
	static int N, M, maxL;
	static int[][] map;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			if(N==0&&M==0)break; // 종료
			
			map = new int[N][M];
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int oCnt = 0; // 연속 1 카운트
				for(int j=0;j<M;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j]==0)
						oCnt = 0;
					else {
						for(int k=j-1;k>=j-oCnt;k--) {
							map[i][k]++;
						}
						oCnt++;
					}
				}
			}
			
			maxL=0;
			func();
			
			bw.write(maxL+"\n");
		}
		
		bw.flush();
		bw.close();
	}
	static void func() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j]==0)continue;
				findSquare(i,j); //탐색
			}
		}
	}
	static void findSquare(int si, int sj) {
		if(si+maxL>=N||sj+maxL>=M)return; // 더 큰 정사각형 찾을 수 없음
		boolean flag = true;
		for(int i=si;i<si+maxL+1;i++) { //현재 최대 정사각형 길이 +1 까지 탐색
			if(map[i][sj]<maxL+1) {
				flag=false;
				break;
			}
		}
		
		if(!flag)return; // 더 큰 정사각형 못찾았음
		
		maxL+=1; // 최대 정사각형길이 +1
		findSquare(si,sj); // 더 큰 사각형 찾을 수 있는지 탐색
	}
}
