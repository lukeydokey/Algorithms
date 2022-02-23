package ssafy.com.algo15;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

/*

백준 1927 최소 힙

 */


public class MinHeap {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> nums = new PriorityQueue<>();
		
		for(int i=0;i<n;i++) {
			int a = Integer.parseInt(br.readLine());
			if(a==0) {
				if(nums.isEmpty())
					bw.write("0\n");
				else {
					bw.write(nums.poll()+"\n");
				}
			}
			else {
				nums.offer(a);
			}
		}
		
		bw.flush();
		bw.close();
		
	}

}
