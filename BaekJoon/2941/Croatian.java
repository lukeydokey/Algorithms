package ssafy.com.algo11;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*

백준 2941번 크로아티아 알파벳

 */

public class Croatian {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException{
		char[] line = br.readLine().toCharArray();
		
		int cnt = 0;//크로아티아 문자 갯수 카운트
		int cur = 0;//현재 문자열에서 위치
		while(cur<line.length) {
			char c = line[cur++];
			switch(c) {
			case 'c':
				if(cur>=line.length) {
					cnt++;
				}
				else if(line[cur]=='='||line[cur]=='-') {
					cnt++;
					cur++;
				}else {
					cnt++;
				}
				break;
			case 'd':
				if(cur>=line.length) {
					cnt++;
				}
				else if(line[cur]=='-') {
					cnt++;
					cur++;
				}else if(line[cur]=='z'&&((cur+1<line.length)&&(line[cur+1]=='='))){
					cnt++;
					cur+=2;
				}
				else {
					cnt++;
				}
				break;
			case 'l':
				if(cur>=line.length) {
					cnt++;
				}
				else if(line[cur]=='j') {
					cnt++;
					cur++;
				}else {
					cnt++;
				}
				break;
			case 'n':
				if(cur>=line.length) {
					cnt++;
				}
				else if(line[cur]=='j') {
					cnt++;
					cur++;
				}else {
					cnt++;
				}
				break;
			case 's':
				if(cur>=line.length) {
					cnt++;
				}
				else if(line[cur]=='=') {
					cnt++;
					cur++;
				}else {
					cnt++;
				}
				break;
			case 'z':
				if(cur>=line.length) {
					cnt++;
				}
				else if(line[cur]=='=') {
					cnt++;
					cur++;
				}else {
					cnt++;
				}
				break;
			default:
				cnt++;
			}
			
		}
		bw.write(cnt+"");
		bw.flush();
		bw.close();
	}

}
