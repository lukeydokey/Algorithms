
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*

백준 10158 개미

*/



public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int w, h;
	static int[] d = {1,1}; 
	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(br.readLine(), " ");
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine(), " ");
		int p = Integer.parseInt(st.nextToken()); // 2w
		int q = Integer.parseInt(st.nextToken()); // 2h
		
		int t = Integer.parseInt(br.readLine());
		
		if(((p+t)/w)%2==1) {
			p = w - (p+t)%w;
		}else {
			p = (p+t)%w;
		}
		if(((q+t)/h)%2==1) {
			q = h - (q+t)%h;
		}else {
			q = (q+t)%h;
		}
		
		bw.write(String.format("%d %d", p, q));
		bw.flush();
		bw.close();
	}
}