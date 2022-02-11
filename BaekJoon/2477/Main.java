
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*

백준 2477 참외

 */

/*

전체 가로 세로 최대길이 위치 구하고
넓이 구한다음에
세로 - 공터 세로
가로 - 공터 가로
넓이 뺌

 */

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int F;
	static int[] wid = new int[3];
	static int[] hei = new int[3];
	static int[] dCnt = new int[4+1]; // 4방향 카운트
	public static void main(String[] args) throws IOException{
		F = Integer.parseInt(br.readLine()); // 밭에서 자라는 참외의 수
		
		
		int wCnt = 0;
		int hCnt = 0;
		for(int i=0;i<6;i++) {
			st= new StringTokenizer(br.readLine(), " ");
			int d = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			dCnt[d]++;
			if(d<3) { // 동이나 서
				hei[hCnt++] = x;
			}else { // 남이나 북
				wid[wCnt++] = x;
			}
		}
		
		int w = 0;
		for(int i=1;i<3;i++) { // 가로 최대값 위치 찾기
			if(wid[w]<wid[i]) {
				w = i;
			}
		}
		int h = 0;
		for(int i=1;i<3;i++) { // 가로 최대값 위치 찾기
			if(hei[h]<hei[i]) {
				h = i;
			}
		}
		
		int result = wid[w] * hei[h]; // 전체 큰 네모 넓이 구하기
		
		if(dCnt[1]==2&&dCnt[3]==2) { // ㄱ자
			int nw = (w+1)%3;
			int nh;
			if(h==0) {
				nh=2;
			}else nh = h-1;
			result -= (wid[w] - wid[nw]) * (hei[h] - hei[nh]);
		}else if(dCnt[2]==2&&dCnt[3]==2) { // ┛자
			int nh = (h+1)%3;
			int nw;
			if(w==0) {
				nw=2;
			}else nw = w-1;
			result -= (wid[w] - wid[nw]) * (hei[h] - hei[nh]);
		}else if(dCnt[2]==2&&dCnt[4]==2) { //┗ 자
			int nw = (w+1)%3;
			int nh;
			if(h==0) {
				nh=2;
			}else nh = h-1;
			result -= (wid[w] - wid[nw]) * (hei[h] - hei[nh]);
			
		}else { 						  // ┏ 자
			int nh = (h+1)%3;
			int nw;
			if(w==0) {
				nw=2;
			}else nw = w-1;
			result -= (wid[w] - wid[nw]) * (hei[h] - hei[nh]);
		}
		
		bw.write(String.format("%d", result*F));
		bw.flush();
		bw.close();
	}

}