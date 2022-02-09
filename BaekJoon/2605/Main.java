
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*

백준 2605 줄세우기

 */

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static ArrayList<Integer> arr = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0;i<N;i++) {
			int a = Integer.parseInt(st.nextToken());
			arr.add(arr.size()-a,i+1);
			
		}
		
		for(int i=0;i<arr.size();i++) {
			bw.write(arr.get(i)+" ");
		}
		bw.flush();
		bw.close();
	}

}
