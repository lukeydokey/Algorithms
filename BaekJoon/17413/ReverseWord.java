package ssafy.com.algo14;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

/*

백준 17413 단어 뒤집기2

 */

public class ReverseWord {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str = br.readLine();
		
		boolean flag = false;
		Stack<Character> stack = new Stack<>();
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i)=='<') {
				while(!stack.isEmpty()) {
					bw.write(stack.pop());
				}
				flag = true;
				bw.write("<");
			}else if(str.charAt(i)=='>') {
				flag = false;
				bw.write(">");
			}else if(flag) {
				bw.write(str.charAt(i));
			}else if(str.charAt(i)==' ') {
				while(!stack.isEmpty()) {
					bw.write(stack.pop());
				}
				bw.write(" ");
			}else {
				stack.push(str.charAt(i));
			}
		}
		while(!stack.isEmpty()) {
			bw.write(stack.pop());
		}
		
		bw.flush();
		bw.close();
	}

}
