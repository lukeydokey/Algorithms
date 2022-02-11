
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*

백준 10157 자리배정

 */


public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int[][] hall;
	static boolean[][] selected;
	static int C,R,K;
	static int[][] dir = {
			{0,1},
			{1,0},
			{0,-1},
			{-1,0}
	};
	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(br.readLine(), " "	);
		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine());
		hall = new int [C+1][R+1];
		selected = new boolean [C+1][R+1];
		
		if(K>C*R) { //배정할 수 없음
			sb.append("0");
		}else {
			func();
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
	static void func() {
		int i=1;
		int j=1;
		if(K==1) {
			sb.append(String.format("%d %d", i,j));
		}
		else {
			selected[1][1]=true; // 첫자리 
			int cnt = 1;
			int d = 0;
			while (cnt < K) {
				int di = i+dir[d][0];
				int dj = j+dir[d][1];
				
				if(di<=C&&di>0&&dj<=R&&dj>0&&!selected[di][dj]) { //선택 되지않고 접근 할수있는 좌석위치
					selected[di][dj] = true;
					cnt++;
					if(cnt==K) { // 번째 대기 관객 좌석위치
						sb.append(String.format("%d %d", di,dj));
						return;
					}
					i = di;
					j = dj;
				}else { // 방향 틀어줌
					d = (d+1) % 4;
				}
			}
		}
	}
}