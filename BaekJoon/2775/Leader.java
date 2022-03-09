package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*

백준 2775 부녀회장이 될테야

 */

public class Leader {

	public static void main(String[] args) throws IOException{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
	    int T = Integer.parseInt(br.readLine());
	    
	    int [][] apt = new int[15][15];
	    for(int i=1;i<=14;i++) {
	    	apt[0][i]= i;
	    }
	    
	    for(int i=1;i<=14;i++) {
	    	for(int j=1;j<=14;j++) {
	    		for(int k=1;k<=j;k++) {
	    			apt[i][j]+= apt[i-1][k];
	    		}
	    	}
	    }
	    
	    for(int t=0;t<T;t++) {
	    	int k = Integer.parseInt(br.readLine());
	    	int n = Integer.parseInt(br.readLine());
	    	
	    	bw.write(String.format("%d\n", apt[k][n]));
	    	
	    }
	    bw.flush();
	    bw.close();
	}

}
