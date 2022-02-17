package ssafy.com.algo11;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*

백준 2851번 슈퍼 마리오

*/

public class SuperMario {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException{
		int[] nums = new int[10];
		for(int i=0;i<10;i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}
		
		int gapMin = 0; //100과 차이가 최소가 되는 Sum
		int sum = 0;
		for(int i=0;i<10;i++) {
			int n = nums[i];
			int tmp = sum+n;
			if(Math.abs(100-gapMin)>= Math.abs(100-tmp)) {
				sum = tmp;
				gapMin = sum;
			}
			
			if(tmp>=100) {
				break;
			}
		}
		
		bw.write(gapMin+"");
		bw.flush();
		bw.close();
	}

}
