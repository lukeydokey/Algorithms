package BaekJoon.Test0218;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*

백준 10809 알파벳 찾기

 */

public class Alphabet {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] input = br.readLine().toCharArray();
		int [] alpha = new int[26]; //'a' = 97 ~ 'z' 122
		for(int i=0;i<26;i++) {
			alpha[i] = -1; //-1로 초기화
		}
		for(int i=0;i<input.length;i++) {
			if(alpha[input[i]-'a']==-1) {
				alpha[input[i]-'a'] = i;
			}
		}
		
		for(int i : alpha) {
			System.out.print(i +" ");
		}
	}

}
