package ssafy.com.algo8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;


/*

백준 1620번 포켓몬 마스터 이다솜

 */




public class PocketMon {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static Map<String, Integer> monsters = new HashMap<>();
    
	public static void main(String[] args) throws IOException{
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		String[] list = new String[N+1];
		for(int i=1;i<=N;i++) {
			String str = br.readLine();
			monsters.put(str, i); //몬스터 이름순
			list[i] = str; //번호 순
		}
		
		for(int i=0;i<M;i++) {
			String q = br.readLine(); // 질문
			
			if(q.charAt(0)>='0'&&q.charAt(0)<='9') { //질문이 도감번호
				int n = Integer.parseInt(q);
				bw.write(list[n]+"\n");
			}else {
				bw.write(monsters.get(q)+"\n");
			}
		}
		
		bw.flush();
		bw.close();
		
	}

}
