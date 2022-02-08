
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/*

백준 11399 ATM

PriorityQueue


 */

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static Queue<Integer> que = new PriorityQueue<>();
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0;i<N;i++) {
			que.offer(Integer.parseInt(st.nextToken()));
		}
		
		int sum=0;
		int result=0;
		while(!que.isEmpty()) {
			sum+=que.poll();
			result+=sum;
		}
		
		bw.write(String.format("%d", result));
		bw.flush();
		bw.close();
	}
}