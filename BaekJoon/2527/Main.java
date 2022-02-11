
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*

백준 2527 직사각형

 */

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int [][] r1 = new int[2][2];
	static int [][] r2 = new int[2][2];
	public static void main(String[] args) throws IOException{
		for(int t=0;t<4;t++) { //4번 수행
			st = new StringTokenizer(br.readLine(), " ");
			for(int i=0;i<4;i++) {
				if(i<2) {
					r1[i][0] = Integer.parseInt(st.nextToken());
					r1[i][1] = Integer.parseInt(st.nextToken());
				}
				else {
					r2[i%2][0] = Integer.parseInt(st.nextToken());
					r2[i%2][1] = Integer.parseInt(st.nextToken());
				}
			}
			
			if((r2[0][0]==r1[1][0])&&(r2[0][1]==r1[1][1])) { //우상단 꼭짓점
				bw.write("c");
			}else if((r2[0][0]==r1[1][0])&&(r2[1][1]==r1[0][1])) { //우하단 꼭짓점
				bw.write("c");
			}else if((r2[1][0]==r1[0][0])&&(r2[0][1]==r1[1][1])) { //좌상단 꼭짓점
				bw.write("c");
			}else if((r2[1][0]==r1[0][0])&&(r2[1][1]==r1[0][1])) { //좌하단 꼭짓점
				bw.write("c");
			}else if((r2[1][1]==r1[0][1]) && (((r2[0][0]>=r1[0][0])&&(r2[0][0]<=r1[1][0])) || ((r2[1][0]>=r1[0][0])&&(r2[1][0]<=r1[1][0])) 
					|| ((r2[1][0]>r1[1][0])&&(r2[0][0]<r1[0][0]))) ) { //하단 선분
				bw.write("b");
			}else if((r2[0][1]==r1[1][1]) && (((r2[0][0]>=r1[0][0])&&(r2[0][0]<=r1[1][0])) || ((r2[1][0]>=r1[0][0])&&(r2[1][0]<=r1[1][0])) 
					|| ((r2[1][0]>r1[1][0])&&(r2[0][0]<r1[0][0]))) ) { //상단 선분
				bw.write("b");
			}else if((r2[1][0]==r1[0][0]) && (((r2[0][1]>=r1[0][1])&&(r2[0][1]<=r1[1][1])) || ((r2[1][1]>=r1[0][1])&&(r2[1][1]<=r1[1][1])) 
					|| ((r2[1][1]>r1[1][1])&&(r2[0][1]<r1[0][1]))) ) { //좌측 선분
				bw.write("b");
			}else if((r2[0][0]==r1[1][0]) && (((r2[0][1]>=r1[0][1])&&(r2[0][1]<=r1[1][1])) || ((r2[1][1]>=r1[0][1])&&(r2[1][1]<=r1[1][1])) 
					|| ((r2[1][1]>r1[1][1])&&(r2[0][1]<r1[0][1]))) ) { //우측 선분
				bw.write("b");
			}else if((r2[0][0]>r1[1][0])||(r2[1][0]<r1[0][0])||(r2[0][1]>r1[1][1])||(r2[1][1]<r1[0][1])){ // 안겹치는 경우
				bw.write("d");
			}else {
				bw.write("a");
			}
			
			bw.write("\n");
		}
		bw.flush();
		bw.close();
	}

}