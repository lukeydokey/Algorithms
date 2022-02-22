package ssafy.com.algo14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*

백준 9655 돌게임

 */

public class Stone {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		if(n%2==0) {
			System.out.println("CY");
		}else if(n%2==1) {
			System.out.println("SK");
		}
		
	}

}
