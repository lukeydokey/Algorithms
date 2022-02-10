
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*

백준 2563 색종이

 */

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int N;
	static int minI = 100;
	static int minJ = 100;
	static int maxI = 0;
	static int maxJ = 0;
	static boolean[][] paper = new boolean[100][100];
	public static void main(String[] args) throws IOException{
		N = Integer.parseInt(br.readLine());
		
		for(int t=0;t<N;t++) {
			st = new StringTokenizer(br.readLine(), " ");
			int j = Integer.parseInt(st.nextToken()) - 1; // x
			int i = Integer.parseInt(st.nextToken()) - 1; // y
			
			for(int a=i;a<i+10;a++) {
				for(int b=j;b<j+10;b++) {
					paper[a][b] = true;
				}
			}
			minI = Math.min(minI, i);
			maxI = Math.max(maxI, i+10);
			minJ = Math.min(minJ, j);
			maxJ = Math.max(maxJ, j+10);
			
		}
		
		int cnt=0;
		for(int i=minI;i<maxI;i++) {
			for(int j=minJ;j<maxJ;j++) {
				if(paper[i][j])
					cnt++;
			}
		}
		
		bw.write(String.format("%d", cnt));
		bw.flush();
		bw.close();
	}

}