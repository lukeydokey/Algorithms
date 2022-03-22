package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.TreeSet;

/*

백준 10867 중복 빼고 정렬하기

 */

public class Sort1 {

	public static void main(String[] args) throws IOException{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    
	    int N = Integer.parseInt(br.readLine());
	    
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		TreeSet<Integer> set = new TreeSet<>();
		for(int i=0;i<N;i++) {
			set.add(Integer.parseInt(st.nextToken()));
		}
		
		for(int i : set) {
			bw.write(i + " ");
		}
		
		bw.flush();
		bw.close();
		
	}

}
