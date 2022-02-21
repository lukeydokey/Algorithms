package BaekJoon.Test0218;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*

백준 2805 나무 자르기

 */

public class CutTree {
	static int max;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int [] tree = new int[n];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0;i<n;i++) {
			tree[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(tree);
		max = 0;
		func(tree, n, m);
		
		System.out.println(max);
	}
	
	static void func(int[] tree, int n, int m) {
		int l = 0;
		int h = tree[n-1];
		while(l<=h) {
			int mid = (l+h)>>1;
			
			if(check(tree, mid, m)) {
				max = Math.max(max, mid);
				l = mid+1;
			}else {
				h = mid-1;
			}
			
		}
	}
	static boolean check(int[] tree, int mid, int m) {
		long sum = 0;
		for(int i=0;i<tree.length;i++) {
			if(tree[i]>mid) sum+= tree[i]-mid;
		}
		
		return sum >= m;
	}
}
