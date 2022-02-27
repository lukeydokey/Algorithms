package ssafy.com.algo17;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*

백준 17144 미세먼지 안녕!

 */

public class Dust {
	static int R, C, T, ci, sum;
	static int map[][];
	static int [][] delTop = {
			{0, 1},
			{-1, 0},
			{0, -1},
			{1, 0}
	};
	static int [][] delBot = {
			{0, 1},
			{1, 0},
			{0, -1},
			{-1, 0}
	};
	static Queue<int[]> q = new LinkedList<>();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		for(int i=0;i<R;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0;j<C;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==-1) {
					ci = i; // 클리너 위치 (클리너 아랫 부분 위치가 최종적으로 저장됨)
				}
			}
		}
		
		for(int i=0;i<T;i++) {
			//미세먼지가 위치한 곳 큐에 넣음
			getList();
			//확산
			spread();
			//클리너 작동
			clean();
		}
		
		sum = 0;
		//남은 미세먼지 갯수
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				sum += map[i][j];
			}
		}
		
		bw.write((sum+2) +""); // 공기청정기 -2 상쇄
		
		bw.flush();
		bw.close();
		
	}
	
	static void getList() {
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(map[i][j]!=-1 && map[i][j]>0) { //미세먼지가 위치한 곳
					q.offer(new int[]{i, j, map[i][j]}); //큐에 위치 먼지 양 저장
				}
			}
		}
	}
	
	static void spread() {
		
		while(!q.isEmpty()) {
			int[] dust = q.poll();
			int di = dust[0];
			int dj = dust[1];
			int dSize = dust[2]; //먼지 양
			
			int cnt = 0;
			for(int d=0;d<4;d++) {
				int ni = di + delTop[d][0];
				int nj = dj + delTop[d][1];
				
				if(ni>=0&&ni<R&&nj>=0&&nj<C&&map[ni][nj]!=-1) { //맵을 벗어나지않고 공기청정기 위치 제외함
					cnt++;
					map[ni][nj] += dSize/5;
				}
				
			}
			
			map[di][dj] -= cnt * (dSize/5);
			
		}
		
	}
	
	static void clean() {
		int cTop = ci - 1 ; //클리너 윗부분 위치
		int cBot = ci; //클리너 아랫부분 위치
		
		//윗부분 클리너 작동
		int curI = cTop;
		int curJ = 1;
		int tmp = 0; //먼지 잠시 저장할 변수
		int d = 0;
		while(!(curI==cTop&&curJ==0)) { // 클리너 윗부분 도착 하면 break
			
			int dust = map[curI][curJ]; //현재 위치 먼지
			map[curI][curJ] = tmp;
			tmp = dust; // 현재 위치 먼지를 임시 저장
			
			int ni = curI + delTop[d][0];
			int nj = curJ + delTop[d][1];
			
			if(ni>=0&&ni<R&&nj>=0&&nj<C) { //맵을 벗어나지 않음
				curI = ni;
				curJ = nj;
			}else { // 맵 벗어남
				d++; //방향 틀어줌
				curI += delTop[d][0];
				curJ += delTop[d][1];
			}
		}

		
		//아랫부분 클리너 작동
		curI = cBot;
		curJ = 1;
		tmp = 0; //먼지 잠시 저장할 변수
		d = 0;
		while (!(curI == cBot && curJ == 0)) { // 클리너 아랫부분 도착 하면 break

			int dust = map[curI][curJ]; //현재 위치 먼지
			map[curI][curJ] = tmp;
			tmp = dust; // 현재 위치 먼지를 임시 저장

			int ni = curI + delBot[d][0];
			int nj = curJ + delBot[d][1];

			if (ni >= 0 && ni < R && nj >= 0 && nj < C) { // 맵을 벗어나지 않음
				curI = ni;
				curJ = nj;
			} else { // 맵 벗어남
				d++; // 방향 틀어줌
				curI += delBot[d][0];
				curJ += delBot[d][1];
			}
		}
		
	}
}
