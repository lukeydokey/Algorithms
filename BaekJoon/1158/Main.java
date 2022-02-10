
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

/*

백준 1158 요세푸스

 */


public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException{
		String[] line = br.readLine().split(" ");
		int N = Integer.parseInt(line[0]);
		int K = Integer.parseInt(line[1]);
		
		Queue<Integer> numbers = new LinkedList<>();
		for(int i=1;i<=N;i++) {
			numbers.offer(i);
		}
		
		int [] result = new int[N];
		int cnt=0;
		while(!numbers.isEmpty()) {
			
			for(int i=0;i<K-1;i++) {
				int tmp = numbers.poll();
				numbers.offer(tmp);
			}
			result[cnt++] = numbers.poll();
		}
		
		bw.write("<");
		for(int i=0;i<N;i++) {
			if(i==N-1) {
				bw.write(result[i]+">");
			}
			else
				bw.write(result[i]+", ");
		}
		
		bw.flush();
		bw.close();
	}

}