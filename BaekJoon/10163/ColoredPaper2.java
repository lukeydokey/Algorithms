package ssafy.com.algo10;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*

백준 10163 색종이

 */

public class ColoredPaper2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int[][] paper = new int[1001][1001];
	public static void main(String[] args) throws IOException{
		int n = Integer.parseInt(br.readLine());
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int sx = Integer.parseInt(st.nextToken()); //색종이 시작 x
			int sy = Integer.parseInt(st.nextToken()); //색종이 시작 y
			int wid = Integer.parseInt(st.nextToken());
			int hei = Integer.parseInt(st.nextToken());
			
			for(int x=sx;x<sx+wid;x++) {
				for(int y=sy;y<sy+hei;y++) {
					paper[x][y] = i+1; //색종이 너비와 높이만큼 덮어줌
				}
			}
		}
		
		int[] cnt = new int[n+1]; // 덮인 색 카운트 배열
		for(int i=0;i<1001;i++) {
			for(int j=0;j<1001;j++){
				cnt[paper[i][j]]++; //덮여있는 색 카운트
			}
		}
		
		for(int i=1;i<=n;i++) {
			bw.write(String.format("%d\n", cnt[i]));
		}
		
		bw.flush();
		bw.close();
	}

}
