package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*

백준 1085 직사각형에서 탈출

 */

public class EscapeSquare {

	public static void main(String[] args) throws IOException{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
	    
		int result = Integer.MAX_VALUE;
		if(x>w/2) {
			result = Math.min(result, w-x);
		}else {
			result = Math.min(result, x);
		}
	    
		if(y>h/2) {
			result = Math.min(result, h-y);
		}else {
			result = Math.min(result, y);
		}
		
		bw.write(result+"");
		bw.flush();
		bw.close();
	}

}
