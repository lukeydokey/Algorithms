package ssafy.com.algo8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*

백준 3040번 백설 공주와 일곱 난쟁이

 */

public class SnowWhite {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] number;
    static int[] result;
	public static void main(String[] args) throws IOException{
		number = new int[9];
		result = new int[7];
		for(int i=0;i<9;i++) {
			number[i] = Integer.parseInt(br.readLine());
		}
		
		func(0, 0, 0);
	}
	
	static void func(int cnt, int start, int sum) {
		if(cnt==7) {
			if(sum==100) {
				for(int i:result)
					System.out.println(i);
			}
		}
		else {
			for(int i=start;i<9;i++) {
				result[cnt] = number[i];
				func(cnt+1, i+1, sum+number[i]);
			}
		}
	}
}
