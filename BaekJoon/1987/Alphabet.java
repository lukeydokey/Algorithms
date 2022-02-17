package ssafy.com.algo11;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*

백준 1987 알파벳

 */

public class Alphabet {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static char[] alphas = new char[26];
	static boolean[] check = new boolean[91];
	static char[][] map;
	static int R, C , moveMax;
	static int[][] dir = {
			{1,0},
			{0,1},
			{-1,0},
			{0,-1}
	};
	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		for(int i=0;i<R;i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		moveMax = 0;
		check[map[0][0]]=true;
		func(0,0,1);
		
		bw.write(moveMax+"");
		bw.flush();
		bw.close();
	}
	
	static void func(int x, int y, int cnt) {
		
		for(int d=0;d<4;d++) { // 4방향 탐색
			int dx = x + dir[d][0];
			int dy = y + dir[d][1];
			
			if(dx>=0&&dx<R&&dy>=0&&dy<C) { //맵을 벗어나면 안됨
				if(!check[map[dx][dy]]) { //탐색 할 위치 알파벳이 안겹치는지 체크
					check[map[dx][dy]] = true;
					func(dx,dy,cnt+1);
					check[map[dx][dy]] = false;
				}
			}
		}
		
		moveMax = Math.max(cnt, moveMax); //최다 선택 수 비교
	}
}
