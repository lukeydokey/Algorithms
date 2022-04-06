package day6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*

백준 2239 스도쿠

 */

public class Sudoku {
	static int[][] result;
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int[][] map = new int[9][9];
		int cnt = 0;
		for(int i=0;i<9;i++) {
			String[] list = br.readLine().split("");
			for(int j=0;j<9;j++) {
				map[i][j] = Integer.parseInt(list[j]);
				if(map[i][j]!=0)
					cnt++;
			}
		}
		result = new int[9][9];
		func(cnt, map);
		for(int[]arr : result) {
			for(int a: arr) {
				bw.write(a+"");
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
	}
	static boolean func(int cnt, int[][]map) {
		if(cnt==81) {
			for(int i=0;i<9;i++) {
				result[i] = map[i].clone();
			}
			return true;
		}else {
			for(int i=0;i<9;i++) {
				for(int j=0;j<9;j++) {
					
					if(map[i][j]!=0)continue;
					
					for(int num=1;num<=9;num++) {
						if(canPut(map, i, j, num)) { //숫자 놓기 성공
							if(func(cnt+1, map)) //숫자 놓고 다음단계 진행
								return true; //스도쿠완성
						}
						map[i][j] = 0;
					}
					
					return false; //숫자 놓기 실패
					
				}
			}
			
		}
		
		return false;
	}
	static boolean canPut(int[][]map, int pi, int pj, int num) {
		for(int i=0;i<9;i++) { //세로 탐색
			if(map[i][pj]==num)
				return false;
		}
		for(int j=0;j<9;j++) { //가로 탐색
			if(map[pi][j]==num)
				return false;
		}
		for(int i=(pi/3)*3;i<(pi/3)*3+3;i++) { //속한 구역 탐색
			for(int j=(pj/3)*3;j<(pj/3)*3+3;j++) {
				if(map[i][j]==num)
					return false;
			}
		}
		
		map[pi][pj]=num;
		return true;
	}
}
