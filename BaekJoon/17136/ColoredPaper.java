package day6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/*

백준 17136 색종이 붙이기

 */

public class ColoredPaper {
	static int[][] map;
	static int[] papers;
	static int pCnt, min;
	public static void main(String[] args) throws IOException{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		map = new int[10][10];
		papers = new int[5+1]; //색종이 종류 1~5
		pCnt = 0;
		for(int i=0;i<10;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j=0;j<10;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==1)
					pCnt++;
			}
		}
		
		min = Integer.MAX_VALUE;
		Arrays.fill(papers, 5); //색종이 갯수 5개
		
		func(0, 0);
		if(min!=Integer.MAX_VALUE)
			bw.write(min+"");
		else
			bw.write(-1+"");
		bw.flush();
		bw.close();
	}
	static void func(int cnt, int paper) {
		if(paper>min)return;
		
		if(cnt==pCnt) {
			min = Math.min(min, paper);
		}else {
			for(int i=0;i<10;i++) {
				for(int j=0;j<10;j++) {
					if(map[i][j]==0)continue;
					
					for(int k=5;k>=1;k--) {
						//색종이 붙일 수 있는지 체크
						if(canPaste(i,j,k)) {
							paste(i,j,k);
							papers[k]--;
							func(cnt+k*k, paper+1);
							unPaste(i,j,k);
							papers[k]++;
						}
					}
					
					//색종이 놓을 수 없는 상황
					return;
				}
			}
		}
	}
	static boolean canPaste(int pi, int pj, int k) {
		if(papers[k]==0)return false; //색종이가 부족
		if(pi+k>10||pj+k>10)return false; //맵을 벗어남
		
		for(int i=pi;i<pi+k;i++) {
			for(int j=pj;j<pj+k;j++) {
				if(map[i][j]==0) return false;
			}
		}
		return true;
	}
	static void paste(int pi, int pj, int k) {
		for(int i=pi;i<pi+k;i++) {
			for(int j=pj;j<pj+k;j++) {
				map[i][j] = 0;
			}
		}
	}
	static void unPaste(int pi, int pj, int k) {
		for(int i=pi;i<pi+k;i++) {
			for(int j=pj;j<pj+k;j++) {
				map[i][j] = 1;
			}
		}
	}
}
