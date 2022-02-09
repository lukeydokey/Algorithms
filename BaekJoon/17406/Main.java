
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*

백준 17406 배열돌리기 4

 */

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int[][] arr;
	static int[][] tmp;
	static int[][] command;
	static int[][] result;
	static boolean[] visited;
	static int[] list;
	static int N, M, K;
	static int min = Integer.MAX_VALUE;
	static int[][] dir = {
			{0,1},
			{1,0},
			{0,-1},
			{-1,0}
	};
	
	
	public static void main(String[] args) throws IOException{
		st= new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		tmp = new int[N][M];
		result = new int[N][M];
		command = new int[K][3];
		visited = new boolean[K];
		list = new int[K];
		for(int i=0;i<N;i++) { //배열 정보
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0;j<M;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0;i<K;i++) { //회전 연산 정보 저장
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0;j<3;j++) {
				command[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		perm(0);
		
		bw.write(String.format("%d", min));
		bw.flush();
		bw.close();
	}
	
	static void rotate(int r, int c, int s) { // r-s c-s ~ r+s c+s 정사각형 회전
		int loop = s;

		for(int i=0;i<tmp.length;i++) {
			System.arraycopy(tmp[i], 0, result[i], 0, tmp[i].length);
		}
		
		
		for(int i=0;i<loop;i++) {
			int ni = r-s+i;
			int nj = c-s+i;
			int d = 0;
			
			while(d<4) {
				int di = ni + dir[d][0];
				int dj = nj + dir[d][1];
				
				if(di<=r+s-i && di>=r-s+i && dj<=c+s-i && dj>=c-s+i) {
					result[di][dj] = tmp[ni][nj];
					ni = di;
					nj = dj;
				}else d++;
			}
		}
		
		for(int i=0;i<result.length;i++) {
			System.arraycopy(result[i], 0, tmp[i], 0, result[i].length);
		}
	}
	
	static void perm(int cnt) {
		if(cnt==K) {
			
			for(int i=0;i<arr.length;i++) { // 원본 카피
				System.arraycopy(arr[i], 0, tmp[i], 0, arr[i].length);
			}
			
			for(int i:list) { // 순서대로 회전
				rotate(command[i][0]-1, command[i][1]-1, command[i][2]);
			}
			
			for(int i=0;i<N;i++) {
				int sum = 0;
				for(int j=0;j<M;j++) {
					sum += tmp[i][j];
				}
				min = Math.min(min, sum);
			}
		} else {
			for(int i=0;i<K;i++) {
				if(visited[i])continue;
				list[cnt]=i;
				visited[i]=true;
				perm(cnt+1);
				visited[i]=false;
			}
		}
	}
}