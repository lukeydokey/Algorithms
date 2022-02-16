package ssafy.com.algo10;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*

백준 13300 방 배정

 */

public class Room {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException{
		st= new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int limit = Integer.parseInt(st.nextToken());
		
		int [][] students = new int[6+1][2];
		for(int i=0;i<n;i++) {
			st= new StringTokenizer(br.readLine(), " ");
			int gender = Integer.parseInt(st.nextToken()); //성별
			int grade = Integer.parseInt(st.nextToken()); //학년
			students[grade][gender]++; //학생수 +
		}
		
		int result = 0 ; //방 갯수
		for(int i=1;i<=6;i++) {
			for(int j=0;j<=1;j++) {
				int num = students[i][j]; //i학년j성별 학생 수
				if(num%limit!=0) {
					result += num/limit +1;
				}else {
					result += num/limit;
				}
			}
		}
		
		bw.write(result+"");
		bw.flush();
		bw.close();
		
	}

}
