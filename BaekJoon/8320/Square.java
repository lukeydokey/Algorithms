package ssafy.com.algo14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*

백준 8320 직사각형을 만드는 방법

 */

public class Square {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int result = 0;
		for(int i=1;i<=n;i++)
			for(int j=i;j*i<=n;j++)
				result++;
		
		System.out.println(result);
	}

}
