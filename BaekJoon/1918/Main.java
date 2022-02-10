
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*

백준 1918 후위표기식

 */

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	
	/*
	
	알파벳은 큐에 연산자는 스택에 넣고 
	만약 peek했는데 + -가 *나/만나면 큐 다 뽑고 스택 다 뽑음 '('만나기 전까지
	다른 연산자는 동일 우선순위 연산자 만나면 1개 뽑음
	'(' 만나는 순간 까지 ')'부터 다 뽑음
	
	*/
	static char[] line;
	static Queue<Character> alpha = new LinkedList<>();
	static Stack<Character> stack = new Stack<>();
	public static void main(String[] args) throws IOException{
		line = br.readLine().toCharArray();
		
		for(int i=0;i<line.length;i++) {
			switch(line[i]) {
			case ')': // 알파벳은 다 뽑고 연산자는 (까지 뽑음
				while(!alpha.isEmpty()) {
					sb.append(alpha.poll());
				}
				while(!stack.isEmpty()) {
					if(stack.peek()=='(') {
						stack.pop();
						break;
					}
					sb.append(stack.pop());
				}
				break;
			case '(': // 연산자에 넣음
				stack.push(line[i]);
				break;
			case '*': // 연산자에 넣음 *나 / 만나면 한개 꺼냄
				if(stack.isEmpty()) {
					stack.push(line[i]);
				}else if(stack.peek()=='*'||stack.peek()=='/') {
					while(!alpha.isEmpty()) {
						sb.append(alpha.poll());
					}
					sb.append(stack.pop());
					stack.push(line[i]);
				}else {
					stack.push(line[i]);
				}
				break;
			case '/': //연산자에 넣음 *나 / 만나면 한개 꺼냄
				if(stack.isEmpty()) {
					stack.push(line[i]);
				}else if(stack.peek()=='*'||stack.peek()=='/') {
					while(!alpha.isEmpty()) {
						sb.append(alpha.poll());
					}
					sb.append(stack.pop());
					stack.push(line[i]);
				}else {
					stack.push(line[i]);
				}
				break;
			case '+': //연산자 peek, * / 만나면 (만나기 전 까지 앞에 다 꺼냄 + - 만나면 한개 꺼냄
				if(stack.isEmpty()) {
					stack.push(line[i]);
				}
				else if(stack.peek()=='*'||stack.peek()=='/') {
					while(!alpha.isEmpty()) {
						sb.append(alpha.poll());
					}
					while(!stack.isEmpty()&&stack.peek()!='(') {
						sb.append(stack.pop());
					}
					stack.push(line[i]);
				}else if(stack.peek()=='+'||stack.peek()=='-') {
					while(!alpha.isEmpty()) {
						sb.append(alpha.poll());
					}
					sb.append(stack.pop());
					stack.push(line[i]);
				}
				else {
					stack.push(line[i]);
				}
				break;
			case '-': //연산자 peek, * / 만나면 (만나기 전 까지 앞에 다 꺼냄 + - 만나면 한개 꺼냄
				if(stack.isEmpty()) {
					stack.push(line[i]);
				}else if(stack.peek()=='*'||stack.peek()=='/') {
					while(!alpha.isEmpty()) {
						sb.append(alpha.poll());
					}
					while(!stack.isEmpty()&&stack.peek()!='(') {
						sb.append(stack.pop());
					}
					stack.push(line[i]);
				}else if(stack.peek()=='+'||stack.peek()=='-') {
					while(!alpha.isEmpty()) {
						sb.append(alpha.poll());
					}
					sb.append(stack.pop());
					stack.push(line[i]);
				}else {
					stack.push(line[i]);
				}
				break;
			default: // 알파벳 넣기
				alpha.offer(line[i]);
			}
		}
		
		//남은거 다 뽑기
		while(!alpha.isEmpty()) {
			sb.append(alpha.poll());
		}
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

}