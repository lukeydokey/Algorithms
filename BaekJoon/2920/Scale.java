package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*

백준 2920 음계

 */

public class Scale {

	public static void main(String[] args) throws IOException{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
	    String[] scale = {"0","1","2","3","4","5","6","7","8"};
	    
	    String[] input = br.readLine().split(" ");
    	boolean flag = false;
	    if(input[0].equals(scale[1])) {
	    	for(int i=1;i<7;i++) {
	    		if(input[i].equals(scale[i+1])) continue;
	    		else {
	    			flag = true;
	    			break;
	    		}
	    	}
	    	if(flag) bw.write("mixed");
	    	else bw.write("ascending");
	    }else if(input[0].equals(scale[8])) {
	    	for(int i=1;i<7;i++) {
	    		if(input[i].equals(scale[8-i])) continue;
	    		else {
	    			flag = true;
	    			break;
	    		}
	    	}
	    	if(flag) bw.write("mixed");
	    	else bw.write("descending");
	    }else {
	    	bw.write("mixed");
	    }
	    
	    bw.flush();
	    bw.close();
	}

}
