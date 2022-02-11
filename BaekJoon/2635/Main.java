
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

/*

백준 2635 수 이어가기

 */

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb;
	static Queue<Integer> nums = new LinkedList<>();
	static LinkedList<Integer> result = new LinkedList<>();
	static int N, max;
	public static void main(String[] args) throws IOException{
		N = Integer.parseInt(br.readLine());
		result.add(N);
		max = 0;
		for(int i=1;i<=N;i++) {
			result.add(i);
			func(N, i, 2);
			result.remove((result.indexOf(i)));
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
	static void func(int a, int b, int cnt) {
		if(a-b<0) {
			if(cnt>max) {
				max = cnt;
				sb = new StringBuilder();
				sb.append(max+"\n");
				for(int i : result) {
					sb.append(i+" ");
				}
			}
			return;
		}else {
			result.add(a-b);
			func(b, a-b, cnt+1);
			result.remove(result.indexOf(a-b));
		}
	}
}
