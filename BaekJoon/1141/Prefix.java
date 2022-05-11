package p0506;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*

백준 1141 접두사

 */

public class Prefix {
	static int N, max;
	static String[] word;
	public static void main(String[] args) throws IOException{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    N = Integer.parseInt(br.readLine());
	    word = new String[N];
	    for(int i=0;i<N;i++) {
	    	word[i] = br.readLine();
	    }
	    Arrays.sort(word);
	    int result = 1;
	    for(int i=0;i<N-1;i++) {
	    	if(word[i+1].length()<word[i].length())
	    		result++;
	    	else {
	    		boolean flag = true; //접두사가 되는지 체크
	    		for(int j=0;j<word[i].length();j++) {
	    			if(word[i].charAt(j)!=word[i+1].charAt(j)) {
	    				flag = false;
	    				break;
	    			}
	    		}
	    		if(!flag) {
	    			result++;
	    		}
	    	}
	    }
	    
	    System.out.println(result);
	}
}
