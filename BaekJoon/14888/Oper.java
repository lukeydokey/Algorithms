package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*

백준 14888 연산자 끼워넣기

*/

public class Oper {
	static int[] nums;
	static boolean[] visited;
	static ArrayList<Character> list;
	static int min, max;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		nums = new int[n];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0;i<n;i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		list = new ArrayList<>();
		st = new StringTokenizer(br.readLine(), " ");
		int plus = Integer.parseInt(st.nextToken());
		for(int i=0;i<plus;i++) {
			list.add('+');
		}
		int minus = Integer.parseInt(st.nextToken());
		for(int i=0;i<minus;i++) {
			list.add('-');
		}
		int multi = Integer.parseInt(st.nextToken());
		for(int i=0;i<multi;i++) {
			list.add('*');
		}
		int divide = Integer.parseInt(st.nextToken());
		for(int i=0;i<divide;i++) {
			list.add('/');
		}
		
		min = Integer.MAX_VALUE;
		max = Integer.MIN_VALUE;
		
		visited = new boolean[list.size()];
		func(0, nums[0]);
		
		bw.write(max+"\n");
		bw.write(min+"\n");
		bw.flush();
		bw.close();
		
	}
	
	static void func(int cnt, int num) {
		if(cnt==list.size()) {
			
			min = Math.min(min, num);
			max = Math.max(max, num);
			
		}else {
			for(int i=0;i<list.size();i++) {
				if(!visited[i]) {
					visited[i] = true;
					func(cnt+1, calc(num, nums[cnt+1], list.get(i)));
					visited[i] = false;
				}
			}
		}
		
	}
	
	static int calc(int a, int b, char oper) {
		
		if(oper=='+') {
			b = a+b;
		}else if (oper=='-') {
			b = a-b;
		}else if (oper=='*') {
			b = a*b;
		}else if (oper=='/') {
			if(a<0) {
				b = Math.abs(a) / b * -1;
			}else {
				b = a/b;
			}
		}
		
		return b;
	}
}
