package ssafy.com.algo3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

// 백준 2493번 탑


public class Main {
	static BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static Stack<Tower> stack = new Stack<Tower>();
	
	public static class Tower {
		int idx;
		int h;
		
		public Tower(int idx, int h) {
			this.idx=idx;
			this.h=h;
		}
	}
	
	public static void main(String[] args) throws IOException{
		int N = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0;i<N;i++) {
			int h = Integer.parseInt(st.nextToken());
			
			if(stack.isEmpty()) {
                sb.append(0).append(" ");
            }
            else {
				while (!stack.isEmpty()) {
					if (stack.peek().h < h) {
						stack.pop();
						if(stack.isEmpty()) {
			                sb.append(0).append(" ");
						}
					} else {
						sb.append(stack.peek().idx).append(" ");
						break;
					}
            	}
            }
			
			stack.push(new Tower(i+1, h));
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

}