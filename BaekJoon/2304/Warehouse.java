package ssafy.com.algo10;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/*

백준 2304번 창고 다각형

*/

public class Warehouse {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int N;
	static int[][] point;
	public static void main(String[] args) throws IOException{
		N = Integer.parseInt(br.readLine());
		point = new int[N][2];
		
		//좌표 저장
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			point[i][0] = Integer.parseInt(st.nextToken());
			point[i][1] = Integer.parseInt(st.nextToken());
		}
		
		//x좌표 기준으로 오름차순 정렬
		Arrays.sort(point, Comparator.comparingInt(o1->o1[0]));
		
		int maxI=0;
		int sum=0;
		//왼->오
		int curX = point[0][0];
		int curY = point[0][1];
		for(int i=1;i<N;i++) {
			if(curY<=point[i][1]) {
				sum += (point[i][0]- curX) * curY;
				curX = point[i][0];
				curY = point[i][1];
				maxI = i;
			}
		}
		
		//오->왼
		curX = point[N-1][0];
		curY = point[N-1][1];
		for(int i=N-1-1;i>=maxI;i--) {
			if(curY<=point[i][1]) {
				sum += Math.abs(point[i][0]- curX) * curY;
				curX = point[i][0];
				curY = point[i][1];
			}
		}
		sum += point[maxI][1];
		bw.write(sum+"");
		bw.flush();
		bw.close();
		
	}

}
