package ssafy.com.algo13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*

백준 3052 나머지

 */

public class Percent {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int [] count = new int [42]; //나머지 카운트
		
		for(int i=0;i<10;i++) {
			int a = Integer.parseInt(br.readLine());
			count[a%42] ++;
		}
		
		int result = 0;
		for(int i=0;i<42;i++) {
			if(count[i]!=0)
				result++;
		}
		
		System.out.println(result);
		
	}

}
