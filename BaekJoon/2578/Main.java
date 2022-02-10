
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*

백준 2578번 빙고

 */


public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int[][] board = new int[5][5];
	static boolean[][] bingo = new boolean[5][5];
	static boolean isbingo;
	static int bcount; //빙고 수
	
	public static void main(String[] args) throws IOException{
		for(int i=0;i<5;i++) { // 빙고판 저장
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0;j<5;j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int cnt=0; // 숫자 부른 횟수
		int result=0;
		for(int i=0;i<5;i++) { //숫자 줄 5개
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0;j<5;j++) { // 빙고 숫자 5개 
				int n = Integer.parseInt(st.nextToken()); // 부른 수
				
				for(int a=0;a<5;a++) {
					for(int b=0;b<5;b++) {
						if(board[a][b] == n) { // 숫자 idx 찾음
							bingo[a][b] = true; // 체크
							check(a, b); // 빙고 됐는지 체크
							cnt++;
							break;
						}
					}
				}
				
				if(bcount>=3&&!(isbingo)) {
					result = cnt;
					isbingo = true;
				}
			}
		}
		
		bw.write(String.format("%d", result));
		bw.flush();
		bw.close();
		
	}
	
	static void check(int a, int b) {
		int cnt = 0 ;
		for(int x=0;x<5;x++) { // 가로
			if(bingo[a][x]) {
				cnt++;
			}
		}
		if(cnt==5) 
			bcount++;
		cnt = 0;
		
		for(int x=0;x<5;x++) { // 세로
			if(bingo[x][b]) {
				cnt++;
			}
		}
		if(cnt==5) 
			bcount++;
		cnt = 0;
		
		if(a==2&&b==2) {
			for (int x = 0; x < 5; x++) { // 좌상->우하
				if (bingo[x][x]) {
					cnt++;
				}
			}
			if (cnt == 5)
				bcount++;
			cnt = 0;

			for (int x = 0; x < 5; x++) { // 우상->좌하
				if (bingo[x][4 - x]) {
					cnt++;
				}
			}
			if (cnt == 5)
				bcount++;
		} else if(a==b){
			for (int x = 0; x < 5; x++) { // 좌상->우하
				if (bingo[x][x]) {
					cnt++;
				}
			}
			if (cnt == 5)
				bcount++;
		} else if((a==4&&b==0)||(a==3&&b==1)||(a==1&&b==3)||(a==0&&b==4)) {
			for (int x = 0; x < 5; x++) { // 우상->좌하
				if (bingo[x][4 - x]) {
					cnt++;
				}
			}
			if (cnt == 5)
				bcount++;
		}
	}
}