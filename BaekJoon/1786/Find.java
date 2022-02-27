package ssafy.com.algo16;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

/*
백준 1786 찾기
 */

public class Find {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		char[] text = br.readLine().toCharArray();
		char[] pattern = br.readLine().toCharArray();
		
		int tLength = text.length, pLength = pattern.length;
		
		//패턴 테이블 만들기
		int[] pi = new int[pLength];
		for(int i=1, j=0; i<pLength; i++) {
			while(j>0 && pattern[i] != pattern[j]) j = pi[j-1];
			
			if(pattern[i] == pattern[j]) {
				pi[i] = ++j;
			}else pi[i] = 0;
			
		}
		
		ArrayList<Integer> list = new ArrayList<>();
		int cnt = 0;
		// 문자열 탐색
		for(int i=0, j=0;i<tLength;i++) {
			
			while(j>0 && text[i] != pattern[j]) j = pi[j-1];
			
			if(text[i] == pattern[j]) {
				if(j==pLength-1) { // 패턴과 같은 부분 발견
					cnt++;
					list.add(( (i+1) - pLength) + 1); // 1번부터 시작이라 +1
					j = pi[j];
				}else {
					j++;
				}
			}
			
		}
		
		bw.write(cnt+"\n");
		if(cnt>0) {
			for( int i : list) {
				bw.write(i + " ");
			}
			bw.write("\n");
		}
		
		bw.flush();
		bw.close();
	}

}
