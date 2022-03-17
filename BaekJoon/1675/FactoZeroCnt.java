package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


/*

백준 1676번 팩토리얼 0의 개수

 */

public class FactoZeroCnt {

	public static void main(String[] args) throws IOException{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
	    // 2 * 5 의 개수
	    
	    int n = Integer.parseInt(br.readLine());
	    
	    int result = 0;
	    
	    result += n / 5;
	    result += n / 25;
	    result += n / 125;
	    
	    bw.write(result +"");
	    bw.flush();
	    bw.close();
	    
	}

}
