package ssafy.com.algo15;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*

백준 18111번 마인크래프트

 */

public class MC {
	static int[][] map;
	static int N, M;
	static int minT,minH;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int item = Integer.parseInt(st.nextToken()); //인벤토리에 가지고있는 블록 갯수
		map = new int[N][M];
		int min = 0;
		int max = 256;
		for(int i=0;i<N;i++) {
			st= new StringTokenizer(br.readLine(), " ");
			for(int j=0;j<M;j++) {
				int a = Integer.parseInt(st.nextToken()); // 맵 저장
				map[i][j] = a; 
				min = Math.min(min, a);
				max = Math.max(max, a);
			}
		}
		
		minT = minH = Integer.MAX_VALUE;
		for(int i=min;i<=max;i++) { // 제일 낮은 블록부터 제일 높은 블록까지 평준화를 모두 시켜본다.
			changeMap(i, item);
		}
		
		bw.write(String.format("%d %d", minT, minH));
		bw.flush();
		bw.close();
	}
	
	static void changeMap(int h, int inventory) { // 맵을 높이 h로 만듦
		
		int t = 0; // 높이 h로 평준화 할 때 걸리는 시간
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				int curH = map[i][j]; // 현재 블록 높이
				if(curH==h)continue;
				if(curH>h) { //목표 높이보다 현재 블록이 높음
					inventory += curH-h; // 깎는 블록 수 만큼 인벤토리에 더해줌
					t += (curH-h) * 2;
				}else { // 현재 블록이 낮음
					inventory -= h-curH; // 쌓는 블록 수 만큼 인벤토리에서 뺌
					t += (h-curH);
				}
			}
		}
		
		if(inventory<0) return;
		
		if(minT>=t) {
			if(minT==t) {
				if(minH<h) {
					minH = h;
				}
			}else {
				minT = t;
				minH = h;
			}
		}
		
	}
}
