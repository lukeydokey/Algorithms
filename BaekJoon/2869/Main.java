
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
 백준 2869번 달팽이는 올라가고 싶다
 */

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		
		int result = 0;
		if((V-A)%(A-B) !=0) {
			result = (V-A) / (A-B) + 2;
		}
		else
			result = (V-A) / (A-B) + 1;
		bw.write(String.format("%d", result));
		bw.flush();
		bw.close();
	}

}