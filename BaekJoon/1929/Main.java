import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*

1929번 소수 구하기

*/


public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static ArrayList<Integer> list = new ArrayList<>();
	public static void main(String[] args) throws IOException{
		st= new StringTokenizer(br.readLine(), " ");
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		for(int i=M;i<=N;i++) {
			if(isPrime(i)) {
				bw.write(i + "\n");
			}
		}
		
		bw.flush();
		bw.close();
	}
	
	static boolean isPrime(int n) {
		if(n<=1) {
			return false;
		}
		
		int sqrt = (int) Math.sqrt(n);
		
		for(int i=2;i<=sqrt;i++) {
			if(n%i==0) {
				return false;
			}
		}
		return true;
		
	}
	
}