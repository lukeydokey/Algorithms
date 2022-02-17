package ssafy.com.algo11;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*

백준 3109 빵집

 */

public class Bakery {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int row, col, ans;
	static char[][] map;
	static int[] rows;
	public static void main(String[] args) throws IOException{
		String[] line = br.readLine().split(" ");
		row = Integer.parseInt(line[0]);
		col = Integer.parseInt(line[1]);
		map = new char[row+1][col+1];
		ans = 0;
		for(int i=1;i<=row;i++) {
			char[]tmp = br.readLine().toCharArray();
			for(int j=1;j<=col;j++) {
				map[i][j] = tmp[j-1];
			}
		}
		
		for(int i=1;i<=row;i++) {
			func(i, 1);
		}
		
		bw.write(ans+"");
		bw.flush();
		bw.close();
	}
	
	static boolean func(int curRow, int curCol) {
		
		//끝까지 설치됨
		if(curCol==col) {
			ans++;
			return true;
		}
		
		//오른쪽 위 옆 아래 검사
		for(int i=curRow-1;i<=curRow+1;i++) {
			//벽이거나 맵을 벗어남
			if(i<1||i>row||map[i][curCol+1]=='x') continue;
			
			//다음 열 행 선택
			map[i][curCol+1]='x';
			
			if(func(i,curCol+1)) { //이미 선택 끝남
				return true;
			}
		}
		
		//끝까지 못감
		return false;
	}
}
