package p0520;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*

백준 3184 양

 */

public class Sheep {
	static char[][] map;
	static int R, C;
	static int sCnt, wCnt, sheep, wolf;
	static int[][] del = {
			{0,1},
			{1,0},
			{0,-1},
			{-1,0}
	};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		
		for(int i=0;i<R;i++) {
			String line = br.readLine();
			for(int j=0;j<C;j++) {
				map[i][j] = line.charAt(j);
			}
		}
		
		sCnt = 0; //양 수
		wCnt = 0; //늑대 수
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(map[i][j]!='#') {
					sheep = 0;
					wolf = 0;
					dfs(i,j);
					if(sheep>wolf) {
						sCnt+=sheep;
					}else {
						wCnt += wolf;
					}
				}
			}
		}
		
		System.out.println(sCnt+" "+wCnt);
	}
	static void dfs(int r, int c) {
		if(map[r][c]=='o') {
			sheep++;
		}else if(map[r][c]=='v') {
			wolf++;
		}
		map[r][c] = '#';
		
		for(int d=0;d<4;d++) {
			int nr = r + del[d][0];
			int nc = c + del[d][1];
			
			if(nr>=0&&nr<R&&nc>=0&&nc<C) {
				if(map[nr][nc]!='#') {
					dfs(nr, nc);
				}
			}
		}
	}
}
