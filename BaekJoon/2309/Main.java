
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/*

백준 2309 일곱난쟁이

 */

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int[] little = new int[9]; // 9난쟁이
	static int[] result = new int[7];
	static int[] height = new int[7];
	static boolean visited;
	public static void main(String[] args) throws IOException{
		for(int i=0;i<9;i++) { //난쟁이 키 인풋
			little[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(little);
		
		func(0,0,0);
		
		for(int h: result) {
			bw.write(h+"\n");
		}
		bw.flush();
		bw.close();
	}
	
	static void func(int cnt, int start, int h) {
		if(cnt==7) {
			if(h==100) {
				result = height.clone();
			}
			return;
		} else {
			for(int i=start;i<9;i++) {
				height[cnt] = little[i];
				func(cnt+1, i+1, h+little[i]);
			}
		}
	}
}