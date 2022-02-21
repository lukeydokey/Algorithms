package BaekJoon.Test0218;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*

백준 16637 괄호 추가하기

 */

public class Bracket {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static boolean [] visited;
	static int[] nums;
	static char[] oper;
	static int n, max;
	public static void main(String[] args) throws IOException{
		n = Integer.parseInt(br.readLine());
		nums = new int[n/2+1];
		oper = new char[n/2];
		visited = new boolean[n/2];
		char[] tmp = br.readLine().toCharArray();
		for(int i=0;i<n;i++) {
			if(i%2==1) {
				oper[i/2] = tmp[i];
			}else {
				nums[i/2] = tmp[i]-'0';
			}
		}
		max = Integer.MIN_VALUE;
		func(0, n/2);
		
		bw.write(max+"");
		bw.flush();
		bw.close();
	}
	static void func(int cnt, int m) {
		if(cnt==m) {
			int[] num = nums.clone(); // 임시 숫자 배열
			for(int i=0;i<m;) {
				if(visited[i]) { // 괄호로 감싸야함
					num[i+1] = calc(num[i], num[i+1], oper[i]);
					i++;
				}else {
					if(i==m-1) { // 마지막 연산
						num[i+1] = calc(num[i], num[i+1], oper[i]);
						i++;
					}
					else if(visited[i+1]) { // 다음 연산이 괄호로 감싸져있음
						int tmp = calc(num[i+1], num[i+2], oper[i+1]);
						num[i+2] = calc(num[i], tmp, oper[i]);
						i+=2;
					}
					else { // 다음 연산도 괄호 x
						num[i+1] = calc(num[i], num[i+1], oper[i]);
						i++;
					}
				}
			}
			
			max = Math.max(max, num[m]); //최댓값이면 교체
			
		}else {
			if(cnt==0) {
				visited[cnt]=true;
				func(cnt+1, m);
				visited[cnt]=false;
				func(cnt+1, m);
			}
			else {
				if(visited[cnt-1]) { //이 전 선택 됐으면 스킵
					func(cnt+1,m);
				}else { // 이 전 선택 안됐음
					visited[cnt]=true;
					func(cnt+1,m);
					visited[cnt]=false;
					func(cnt+1,m);
				}
			}
		}
	}
	
	static int calc(int a, int b, char op) {
		if(op=='*') {
			return a * b;
		}else if(op=='+') {
			return a+b;
		}
		
		return a-b;
	}
}
