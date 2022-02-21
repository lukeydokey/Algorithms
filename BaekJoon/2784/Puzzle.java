package ssafy.com.algo13;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

/*

백준 2784 가로세로 퍼즐

 */

public class Puzzle {
	static String[] words = new String[6];
	static int[] visited = new int[3];
	static boolean[] visit = new boolean[6];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for(int i=0;i<6;i++) {
			words[i] = br.readLine();
		}
		
		if(func(0)) {
			bw.write(sb.toString());
		}
		else {
			bw.write("0");
		}
		
		bw.flush();
		bw.close();
	}
	static boolean func(int cnt) {
		if(cnt==3) {
			char[][]tmp = new char[3][3];
			int c = 0;
			ArrayList<String> s = new ArrayList<>();
			//선택된 단어로 3x3행렬 만듦
			for(int i=0;i<3;i++) {
				tmp[c++] = words[visited[i]].toCharArray();
			}
			
			//선택 안된 단어들 저장
			for(int i=0;i<6;i++) {
				if(!visit[i])
					s.add(words[i]);
			}
			
			StringBuilder str;
			int count=0;
			for(int j=0;j<3;j++) {
				str = new StringBuilder();
				for(int i=0;i<3;i++) {
					str.append(tmp[i][j]); //세로로 단어 저장
				}
				for(int x=s.size()-1;x>=0;x--) { //세로저장된 단어들과 선택안된 단어 비교
					if(s.get(x).equals(str.toString())) {
						s.remove(x);
						count++;
						break;
					}
				}
			}
			
			if(count==3) { // 선택 안된 단어들로 세로가 이루어져있음
				for(int i=0;i<3;i++) {
					for(int j=0;j<3;j++) {
						sb.append(tmp[i][j]);
					}
					sb.append("\n");
				}
				return true;
			}
			
			
		}else {
			for(int i=0;i<6;i++) {
				if(!visit[i]) {
					visit[i]=true;
					visited[cnt] = i;
					if(func(cnt+1))
						return true;
					visited[cnt] = 0;
					visit[i]=false;
				}
			}
		}
		
		return false;
	}
}
