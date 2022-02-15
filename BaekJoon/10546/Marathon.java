package ssafy.com.algo9;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

/*

백준 10546 배부른 마라토너

 */



public class Marathon {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static Map<String, Integer> man = new HashMap<String,Integer>();
	public static void main(String[] args) throws IOException{
		int n = Integer.parseInt(br.readLine());
		
		for(int i=0;i<n;i++) {
			String name = br.readLine();
			if(!man.containsKey(name)) { 
				man.put(name, 1);
			}else {
				man.replace(name, man.get(name)+1); //동명이인 참가 시
			}
		}
		
		for(int i=0;i<n-1;i++) {
			String name = br.readLine();
			if(man.get(name)== 1) { // 동명이인 X
				man.remove(name);
			}else {
				man.replace(name, man.get(name)-1); //동명이인 수 -1
			}
		}
		
		for(String s: man.keySet()) // 남은 1명의 완주못한 마라토너 출력
			bw.write(s);
		
		bw.flush();
		bw.close();
	}

}
