package ssafy.com.algo8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*

백준 2961번 도영이가 만든 맛있는 음식

 */

public class Cook {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N;
    static boolean[] visited;
    static int[] sour;
    static int[] bit;
    static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException{
		N = Integer.parseInt(br.readLine());
		
		sour = new int[N];
		bit = new int[N];
		visited = new boolean[N];
		for(int i=0;i<N;i++) {
			st= new StringTokenizer(br.readLine(), " ");
			sour[i] = Integer.parseInt(st.nextToken());
			bit[i] = Integer.parseInt(st.nextToken());
		}
		
		func(0,0,0);
		
		bw.write(String.format("%d", min));
		bw.flush();
		bw.close();
	}
	
	static void func(int cnt, int sourSum, int bitSum) {
		
		if(cnt == N) {
			if(sourSum==0&&bitSum==0) {
				return;
			}
			else {
				int gap = Math.abs(sourSum - bitSum);
				if (gap < min) {
					min = gap;
				}
			}
		}
		else {
			visited[cnt] = true;
			if(sourSum!=0)
				func(cnt+1, sourSum*sour[cnt], bitSum+bit[cnt]);
			else {
				func(cnt+1, sour[cnt], bit[cnt]);
			}
			visited[cnt] = false;
			func(cnt+1, sourSum, bitSum);
		}
	}
}
