package ssafy.com.algo12;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*

백준 15683 감시

*/

public class CCTV {
	static int [][] dir = {
			{-1, 0},
			{0, 1},
			{1, 0},
			{0, -1}
	};
	static int[][] map;
	static int min;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine(), " ");
		
		int row = Integer.parseInt(st.nextToken());
		int col = Integer.parseInt(st.nextToken());
		
		map = new int [row][col];
		int cctvCnt = 0;
		for(int i=0;i<row;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0;j<col;j++) {
				int tmp = Integer.parseInt(st.nextToken());
				map[i][j] = tmp;
				if(tmp>=1&&tmp<6) cctvCnt++; //CCTV 갯수 세어줌
			}
		}
		
		//cctv 정보 저장
		int[][] cctvInfo = new int[cctvCnt][3]; // 종류, row, col
		int cnt = 0;
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				int tmp = map[i][j];
				if(tmp>=1&&tmp<6) {
					cctvInfo[cnt][0] = tmp; //cctv종류
					cctvInfo[cnt][1] = i; // row
					cctvInfo[cnt][2] = j; // col
					cnt++;
				}
			}
		}
		
		int[]directions = new int[cctvCnt]; //cctv의 방향을 저장할 배열
		
		min = Integer.MAX_VALUE;
		dfs(0, cctvCnt, cctvInfo, directions);
		
		bw.write(min+"");
		bw.flush();
		bw.close();
	}
	
	static void dfs (int depth, int n, int[][] cctvInfo, int[] directions) {
		if(depth==n) {
			//cctv정보와 cctv의 방향 중복순열을 가지고 사각지대 탐색
			blindSide(cctvInfo, directions);
		}
		else {
			for(int i=0;i<4;i++) {
				directions[depth] = i;
				dfs(depth+1, n, cctvInfo, directions);
			}
		}
	}
	
	static void blindSide(int[][] cctvInfo, int[] directions) {
		int n = cctvInfo.length; // cctv갯수
		int[][] tmpMap = new int[map.length][map[0].length]; //연산용 임시 맵
		for(int i = 0; i < map.length; i++){
			System.arraycopy(map[i], 0, tmpMap[i], 0, tmpMap[i].length);
		}
		
		for(int i=0;i<n;i++) {
			//cctv의 방향대로 맵을 감시
			int row = cctvInfo[i][1]; //cctv가 위치한곳
			int col = cctvInfo[i][2];
			int cctv = cctvInfo[i][0]; //cctv 종류
			int direction = directions[i]; // 바라보고 있는 방향
			
			if(cctv==1) { //바라보는 방향 마스킹
				masking(tmpMap, row, col, direction);
			}else if(cctv==2) { // 바라보는 방향과 반대편 방향 2방향 마스킹
				masking(tmpMap, row, col, direction);
				masking(tmpMap, row, col, direction+2);
			}else if(cctv==3) { // 바라보는방향과 오른쪽 방향 2방향 마스킹
				masking(tmpMap, row, col, direction);
				masking(tmpMap, row, col, direction+1);
			}else if(cctv==4) { // 바라보는방향과 양옆 3방향 마스킹
				masking(tmpMap, row, col, direction+3); // 왼쪽
				masking(tmpMap, row, col, direction);
				masking(tmpMap, row, col, direction+1); // 오른쪽
			}else if(cctv==5) { // 4방향 마스킹
				masking(tmpMap, row, col, direction);
				masking(tmpMap, row, col, direction+1);
				masking(tmpMap, row, col, direction+2);
				masking(tmpMap, row, col, direction+3);
			}
		}
		
		int cnt = 0; //사각지대 카운트
		for(int i=0;i<map.length;i++) {
			for(int j=0;j<map[0].length;j++) {
				if(tmpMap[i][j]==0) {
					cnt++;
				}
			}
		}
		
		//사각지대 최솟값과 현재 사각지대 카운트 비교
		min = Math.min(min, cnt);
	}
	
	static void masking(int[][]tmpMap, int i, int j, int d) {
		d %= 4; //d가 3을 넘을경우 관리
		
		int di = i + dir[d][0];
		int dj = j + dir[d][1];
		
		while(di<tmpMap.length&&di>=0&&dj<tmpMap[0].length&&dj>=0) { //맵을 벗어나지 않는 동안
			if(tmpMap[di][dj]==6) { //벽을 만나면
				break;
			}else if(tmpMap[di][dj]>=1&&tmpMap[di][dj]<6) { //카메라를 만나면
				di += dir[d][0];
				dj += dir[d][1];
			}else {
				tmpMap[di][dj] = -1; // 감시받는 지역
				di += dir[d][0];
				dj += dir[d][1];
			}
		}
	}
}
