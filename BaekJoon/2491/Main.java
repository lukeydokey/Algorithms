
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*

백준 2491번 수열

 */


public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N;
	static int cnt_Max = 1;
	static boolean isDesc;
	static boolean isSame;
	static int[] numbers;
	public static void main(String[] args) throws IOException{
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		numbers = new int[N];
		for(int i=0;i<N;i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0;i<N-1;i++) {
			if(numbers[i]>numbers[i+1]) {
				isDesc = true;
				break;
			}
		}
		
		func(1, 0);
		
		bw.write(String.format("%d", cnt_Max));
		bw.flush();
		bw.close();
	}
	
	static void func(int cnt, int sameNum) {
		for(int i=0;i<N-1;i++) {
			if(isDesc) {
				if(numbers[i]>numbers[i+1]) {
					cnt++;
					isSame=false;
					sameNum=0;
				}
				else if(numbers[i]==numbers[i+1]) {
					isSame=true;
					sameNum++;
					cnt++;
				}
				else {
					cnt_Max =Math.max(cnt_Max, cnt);
					if(isSame) {
						cnt = 2 + sameNum;
						isSame = false;
					}
					else
						cnt = 2;
					sameNum = 0;
					isDesc = !isDesc;
				}
			}
			else {
				if(numbers[i]<numbers[i+1]) {
					cnt++;
					isSame=false;
					sameNum=0;
				}
				else if(numbers[i]==numbers[i+1]) {
					isSame=true;
					sameNum++;
					cnt++;
				}
				else {
					cnt_Max = Math.max(cnt_Max, cnt);
					if(isSame) {
						cnt = 2 + sameNum;
						isSame = false;
					}
					else
						cnt = 2;
					sameNum = 0;
					isDesc = !isDesc;
				}
			}
		}
		
		cnt_Max = Math.max(cnt_Max, cnt);
	}
	
}