
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*

백준 16926 배열돌리기1

 */

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int[][] arr;
	static int[][] result;
	static int N, M, di, dj;
	static int[][] dir = {
			{1,0},
			{0,1},
			{-1,0},
			{0,-1}
	};
	
	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		
		arr = new int[N][M];
		result = new int[N][M];
		for(int i=0;i<N;i++) { //배열 저장
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0;j<M;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		rotate(R);
		
		for(int[] a:result) {
			for(int i: a) {
				bw.write(i+" ");
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
	}
	
	static void rotate(int ro) {
		int loop = Math.min(N, M) / 2;
		for(int l = 0; l<loop;l++) {
			if(l==loop-1) { //가장 내부 회전
				for(int i=l;i<N-l;i++) {
					for(int j=l;j<M-l;j++) {
						di = i;
						dj = j;
						if(i<N-l-1&&j==l) { // 좌측
							int d = 0;
							func(d, l, ro);
							result[di][dj] = arr[i][j];
						} else if(i==N-l-1&&j<M-l-1) { // 하단
							int d = 1;
							func(d, l, ro);
							result[di][dj] = arr[i][j];
						} else if(i>l&&j==M-l-1) { // 우측
							int d = 2;
							func(d, l, ro);
							result[di][dj] = arr[i][j];
						} else { // 상단
							int d = 3;
							func(d, l, ro);
							result[di][dj] = arr[i][j];
						}
					}
				}
			}
			else { // 외부 회전
				for(int i=l;i<N-l;i++) {
					for(int j=l;j<M-l;j++) {
						if(i>l&&i<N-l-1&&j>l&&j<M-l-1) { // 더 내부면 체크 스킵
							continue;
						}
						else {
							di = i;
							dj = j;
							if(i<N-l-1&&j==l) { // 좌측
								int d = 0;
								func(d, l, ro);
								result[di][dj] = arr[i][j];
							} else if(i==N-l-1&&j<M-l-1) { // 하단
								int d = 1;
								func(d, l, ro);
								result[di][dj] = arr[i][j];
							} else if(i>l&&j==M-l-1) { // 우측
								int d = 2;
								func(d, l, ro);
								result[di][dj] = arr[i][j];
							} else { // 상단
								int d = 3;
								func(d, l, ro);
								result[di][dj] = arr[i][j];
							}
						}
					}
				}
			}
		}
	}
	
	static void func(int d, int l, int ro) {
		for(int r=0;r<ro;r++) { // r번 회전
			int tmpdi = di + dir[d][0];
			int tmpdj = dj + dir[d][1];
			if(tmpdi>=N-l||tmpdi<l||tmpdj>=M-l||tmpdj<l) { //진행방향 바꿔주기
				d = (d + 1) % 4;
			}
			di += dir[d][0];
			dj += dir[d][1];
		}
	}
}