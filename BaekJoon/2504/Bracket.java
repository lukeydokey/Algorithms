package ssafy.com.algo15;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

/*

백준 2504 괄호의 값

 */

public class Bracket {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Stack<String> stack = new Stack<>();
		
		String str = br.readLine();
		boolean flag = false;
		for(int i=0;i<str.length();i++) {
			char c = str.charAt(i);
			switch(c) {
			case '(':
				stack.push(c+"");
				break;
			case '[':
				stack.push(c+"");
				break;
			case ')':
				if(stack.isEmpty()) {
					flag = true;
				}
				else if(stack.peek().equals("(")) {
					stack.pop();
					stack.push("2");
				}else {
					int sum = 0;
					while(!stack.isEmpty()) {
						if(!stack.peek().equals("[")&&!stack.peek().equals("(")) { // 숫자가 Top
							sum += Integer.parseInt(stack.pop());
						}else if(stack.peek().equals("(")) {
							stack.pop();
							sum*=2;
							stack.push(sum+"");
							break;
						}else if(stack.peek().equals("[")) { //유효하지 않음
							flag = true;
							break;
						}
					}
				}
				break;
			case ']':
				if(stack.isEmpty()) {
					flag = true;
				}
				else if(stack.peek().equals("[")) {
					stack.pop();
					stack.push("3");
				}else {
					int sum = 0;
					while(!stack.isEmpty()) {
						if(!stack.peek().equals("[")&&!stack.peek().equals("(")) { // 숫자가 Top
							sum += Integer.parseInt(stack.pop());
						}else if(stack.peek().equals("[")) {
							stack.pop();
							sum*=3;
							stack.push(sum+"");
							break;
						}else if(stack.peek().equals("(")) { //유효하지 않음
							flag = true;
							break;
						}
					}
				}
				break;
			}
			
			if(flag)break;
		}
		
		int result = 0;
		while(!stack.isEmpty()) {
			if(stack.peek().equals("(")||stack.peek().equals("[")) {
				flag = true;
				break;
			}
			result += Integer.parseInt(stack.pop());
		}
			
		if(flag) bw.write("0");
		else {
			bw.write(result+"");
		}
		
		bw.flush();
		bw.close();
	}

}
