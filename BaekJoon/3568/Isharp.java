package p0506;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Stack;

/*

백준 3568 isharp

 */

public class Isharp {

	public static void main(String[] args) throws IOException{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    
	    String command = br.readLine();
	    
	    StringBuilder shared = new StringBuilder();
	    int cur = 0;
	    while(true) {
	    	if(command.charAt(cur)!=' ')
	    		shared.append(command.charAt(cur++));
	    	else {
	    		break;
	    	}
	    }
	    
	    ArrayList<String> decl = new ArrayList<>();
	    Stack<Character> stack = new Stack<>();
	    StringBuilder name = new StringBuilder();
	    while(true) {
	    	if(command.charAt(cur)==' ') {
	    		name = new StringBuilder();
	    	}else if(command.charAt(cur)==',') {
	    		StringBuilder sb = new StringBuilder();
	    		while(!stack.isEmpty()) {
	    			sb.append(stack.pop());
	    		}
	    		decl.add(shared.toString()+sb.toString()+" "+name.toString());
	    	}else if(command.charAt(cur)==';') {
	    		StringBuilder sb = new StringBuilder();
	    		while(!stack.isEmpty()) {
	    			sb.append(stack.pop());
	    		}
	    		decl.add(shared.toString()+sb.toString()+" "+name.toString());
	    		break;
	    	}else if(command.charAt(cur)=='&'||command.charAt(cur)=='*'||command.charAt(cur)=='['||command.charAt(cur)==']'){
	    		if(command.charAt(cur)=='[') {
	    			stack.push(']');
	    		}else if(command.charAt(cur)==']') {
	    			stack.push('[');
	    		}else {
	    			stack.push(command.charAt(cur));
	    		}
	    	}else {
	    		name.append(command.charAt(cur));
	    	}
	    	cur++;
	    }
	    
	    for(String s : decl) {
	    	bw.write(s+";\n");
	    }
	    bw.flush();
	    bw.close();
	}

}
