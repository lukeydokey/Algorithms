package ssafy.com.algo14;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*

백준 8958 OX퀴즈

 */

public class OX {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		
		for(int i=0;i<n;i++) {
			String str = br.readLine();
			int result = 0;
			int cnt = 0;
			for(int j=0;j<str.length();j++) {
				if(str.charAt(j)=='O') {
					result += ++cnt;
				}else {
					cnt = 0;
				}
			}
			
			bw.write(result+"\n");
		}
		
		bw.flush();
		bw.close();
	}

}
