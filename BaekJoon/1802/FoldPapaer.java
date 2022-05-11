package p0511;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*

백준 1802 종이접기

 */

public class FoldPapaer {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0;t<T;t++) {
			String cur = br.readLine();
			int length = cur.length();
			int mid = length>>1;
			boolean flag = true;
			outer : while(mid!=0) {
				for(int i=1;i+mid<length;i++) {
					if(cur.charAt(mid+i)==cur.charAt(mid-i)) {
						flag=false;
						break outer;
					}
				}
				
				length = length>>1;
				mid = mid>>1;
			}
			if(flag)
				bw.write("YES\n");
			else
				bw.write("NO\n");
		}
		
		bw.flush();
		bw.close();
		
		
	}

}
