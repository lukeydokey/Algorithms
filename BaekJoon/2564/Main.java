
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*

백준 2564번 경비원

 */


public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int [][] store;
	static int [] dong = new int[2];
	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(br.readLine(), " ");
		int wid = Integer.parseInt(st.nextToken());
		int hei = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(br.readLine());
		store = new int[N][2];
		for(int t=0;t<N;t++) {
			st = new StringTokenizer(br.readLine(), " ");
			store[t][0] = Integer.parseInt(st.nextToken()); // 상점 위치
			store[t][1] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine(), " "); // 동근이 위치
		dong[0] = Integer.parseInt(st.nextToken());
		dong[1] = Integer.parseInt(st.nextToken());
		
		/*
		동근이 위치와 상점 위치 사이의 최단거리를 모두 합해서 출력
		1: 북 	2: 남	 3: 서 	4: 동
		*/
		
		int sum = 0;
		for(int t=0;t<N;t++) {
			int sd = store[t][0]; // 상점이 있는 방향
			int sx = store[t][1]; // 방향에서 얼마 떨어져있는지
			if(dong[0]==sd) { //같은 방향에 있을 때
				sum+= Math.abs(dong[1]-sx);
			} else if(dong[0]==1){ // 북
				if(sd==2) {
					sum+= Math.min(dong[1]+sx, (wid-dong[1])+(wid-sx)) + hei; // 반대편
				}else if(sd==3) { 
					sum+= dong[1]+sx;
				}else if(sd==4) { 
					sum+= (wid-dong[1])+sx;
				}
			} else if(dong[0]==2) { // 남
				if(sd==1) { 
					sum+= Math.min(dong[1]+sx, (wid-dong[1])+(wid-sx)) + hei; // 반대편
				}else if(sd==3) {
					sum+= dong[1] + hei - sx;
				}else if(sd==4) {
					sum+= wid-dong[1] + hei-sx;
				}
			}else if(dong[0]==3) { // 서
				if(sd==1) {
					sum+=dong[1] + sx;
				}else if(sd==2) {
					sum+= hei-dong[1] + sx;
				}else if(sd==4) {
					sum+= Math.min(dong[1]+sx, (hei-dong[1])+(hei-sx)) + wid; // 반대편
				}
			}else if(dong[0]==4) { // 동
				if(sd==1) {
					sum+= dong[1] + wid-sx;
				}else if(sd==2) {
					sum+= hei-dong[1] + wid-sx;
				}else if(sd==3) {
					sum+= Math.min(dong[1]+sx, (hei-dong[1])+(hei-sx)) + wid; // 반대편
				}
			}
			
		}
		bw.write(String.format("%d", sum));
		bw.flush();
		bw.close();
	}

}
