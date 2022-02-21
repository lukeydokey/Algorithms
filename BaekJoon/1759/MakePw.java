package ssafy.com.algo13;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/*

백준 1759 암호 만들기

 */

public class MakePw {
	static int L;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		L = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine(), " ");
		char[] letters = new char[C];
		visited = new boolean[C];
		for(int i=0;i<C;i++) {
			letters[i] = st.nextToken().charAt(0);
		}
		
		//암호 문자열 오름차순 정렬
		Arrays.sort(letters);
		
		func(letters, 0, 0);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
	static void func(char[] letters, int cnt, int start) {
		if(cnt==L) {
			StringBuilder tmp = new StringBuilder();
			for(int i=0;i<letters.length;i++) {
				if(visited[i])
					tmp.append(letters[i]);
			}
			char[] pw = tmp.toString().toCharArray();
			int vCnt = 0; //모음 카운트
			int cCnt = 0; //자음 카운트
			for(int i=0;i<pw.length;i++) {
				if(pw[i]=='a'||pw[i]=='e'||pw[i]=='i'||pw[i]=='o'||pw[i]=='u')
					vCnt++;
				else
					cCnt++;
			}
			
			if(vCnt>=1&&cCnt>=2) { // pw는 1개 이상의 모음 , 2개 이상의 자음으로 이루어짐
				sb.append(tmp.toString()+"\n");
			}
			
		}else {
			for(int i = start;i<letters.length;i++) {
				visited[i] = true;
				func(letters, cnt+1, i+1);
				visited[i] = false;
			}
		}
	}
}
