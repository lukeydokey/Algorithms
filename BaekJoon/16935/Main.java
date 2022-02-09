
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*

백준 16935 배열돌리기3

 */

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int[][] arr;
	static int[][] result;
	static int N, M;
	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		for(int i=0;i<N;i++) { //배열 저장
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0;j<M;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0;i<R;i++) { // R번 연산 반복
			int F = Integer.parseInt(st.nextToken()); // 수행할 연산
			func(F);
		}
		
		for(int[] a:arr) {
			for(int i: a) {
				bw.write(i+" ");
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
		
	}
	
	static void func(int F) {
		switch(F) {
		case 1: // 연산 1
			result = new int[N][M];
			reverse(1);
			return;
		case 2: // 연산 2
			result = new int[N][M];
			reverse(2);
			return;
		case 3: // 연산 3
			result = new int[M][N];
			rotate(1);
			return;
		case 4: // 연산 4
			result = new int[M][N];
			rotate(-1);
			return;
		case 5: // 연산 5
			result = new int[N][M];
			groupRotate(1);
			return;
		case 6: // 연산 6
			result = new int[N][M];
			groupRotate(-1);
			return;
		}
	}
	
	static void reverse(int state) {
		if(state == 1) {// 상하반전
			for(int i=0;i<N/2;i++) {
				for(int j=0;j<M;j++) {
					result[i][j] = arr[N-1-i][j];
					result[N-1-i][j] = arr[i][j];
				}
			}
		}
		else { // 좌우반전
			for(int i=0;i<N;i++) {
				for(int j=0;j<M/2;j++) {
					result[i][j] = arr[i][M-1-j];
					result[i][M-1-j] = arr[i][j];
				}
			}
		}
		
		arr = result;
	}
	
	static void rotate(int state) {
		if(state == 1) { // 오른쪽 90도
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					result[j][N - 1 - i] = arr[i][j];
				}
			}
		}
		else { // 왼쪽 90도
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					result[M - 1 - j][i] = arr[i][j];
				}
			}
			
		}
		
		//크기 변환
		int tmp = N;
		N = M;
		M = tmp;
		
		arr = result;
	}
	
	static void groupRotate(int state) {
		if(state == 1) { // 그룹 오른쪽 회전
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					if(i<N/2&&j<M/2) // 1->2
						result[i][j+(M/2)]=arr[i][j];
					else if(i<N/2&&j<M)// 2->3
						result[i+(N/2)][j]=arr[i][j];
					else if(j>=M/2) { // 3-> 4
						result[i][j-(M/2)]=arr[i][j];
					}
					else { // 4 -> 1
						result[i-(N/2)][j]=arr[i][j];
					}
				}
			}
		}
		else { // 그룹 왼쪽 회전
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					if(i<N/2&&j<M/2) // 1->4
						result[i+(N/2)][j]=arr[i][j];
					else if(i<N/2&&j<M)// 2->1
						result[i][j-(M/2)]=arr[i][j];
					else if(j>=M/2) { // 3->2
						result[i-(N/2)][j]=arr[i][j];
					}
					else { // 4->3
						result[i][j+(M/2)]=arr[i][j];
					}
				}
			}
		}
		
		arr = result;
	}
}