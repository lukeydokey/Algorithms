package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*

백준 14503 로봇 청소기

*/

public class RobotCleaner {
	static int N, M, result;
	static int[][] del = {
			{-1, 0 },
			{0, 1},
			{1, 0},
			{0, -1}
	};
	static int[][] map;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine(), " ");
		int ri = Integer.parseInt(st.nextToken()); //로봇 좌표, 바라보는 방향
		int rj = Integer.parseInt(st.nextToken());
		int rd = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		result = 0;
		cleaning(ri, rj, rd);
		
		bw.write(result+"");
		bw.flush();
		bw.close();
	}
	static boolean cleaning(int ri, int rj, int rd) {
		
		if(map[ri][rj]==0) {
			map[ri][rj] = 2;
			result++; // 청소
		}
		
		int cnt = 0;
		for(int d=0;d<4;d++) {
			int nd = (4 + rd - (1+d)) % 4;
			int ni = ri + del[nd][0];
			int nj = rj + del[nd][1];
			
			if(ni>=0&&ni<N&&nj>=0&&nj<M&& map[ni][nj]==0) { // 청소하지 않은 공간 발견
				if(cleaning(ni, nj, nd)) return true;
			}else { //청소 공간 x
				cnt++;
				continue;
			}
			
		}
		
		if(cnt==4) { //4방향 모두 청소 불가
			int nd = (4 + rd - 2) % 4; //뒤쪽 방향
			int ni = ri + del[nd][0];
			int nj = rj + del[nd][1];
			
			if(ni>=0&&ni<N&&nj>=0&&nj<M&& map[ni][nj]!=1) { //벽이 아님
				if(cleaning(ni, nj, rd)) return true;//바라보는 방향 유지
			}else {
				return true;
			}
			
			
		}
		
		return true;
	}
}
