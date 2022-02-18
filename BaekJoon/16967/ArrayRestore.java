package BaekJoon.Test0218;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*

백준 16967 배열 복원하기

 */

public class ArrayRestore {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		
		int [][] newArr = new int[r+x][c+y];
		for(int i=0;i<newArr.length;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0;j<newArr[0].length;j++) {
				newArr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int [][] result = new int[r][c];
		for(int i=x;i<r+x;i++) {
			for(int j=y;j<c+y;j++) {
				if(i<=x+(r-x-1)&&j<=y+(c-y-1)) { // 겹친 부분
					result[i-x][j-y] = newArr[i-x][j-y];
					newArr[i][j] -= newArr[i-x][j-y];
				}else {
					result[i-x][j-y] = newArr[i][j];
				}
			}
		}
		
		for(int a[] : result) {
			for(int i : a)
				System.out.print(i+" ");
			System.out.println();
		}
	}

}
