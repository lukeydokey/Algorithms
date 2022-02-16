package ssafy.com.algo10;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/*

백준 2628번 종이자르기

 */

public class CutPaper {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(br.readLine(), " ");
		int wid = Integer.parseInt(st.nextToken());//종이 가로 세로
		int hei = Integer.parseInt(st.nextToken());
		
		int c = Integer.parseInt(br.readLine()); //자른 횟수
		ArrayList<Integer> cutWid = new ArrayList<>(); //가로 길이를 세로로 자름
		ArrayList<Integer> cutHei = new ArrayList<>(); //세로 길이를 가로로 자름
		for(int i=0;i<c;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			if(st.nextToken().equals("1")) {
				cutWid.add(Integer.parseInt(st.nextToken()));
			}else {
				cutHei.add(Integer.parseInt(st.nextToken()));
			}
		}
		
		Collections.sort(cutWid);
		int maxW = 0;
		int start = 0;
		for(int i=0;i<cutWid.size();i++) {
			if(cutWid.get(i)-start>maxW) {
				maxW = cutWid.get(i)-start;
			}
			start = cutWid.get(i);
		}
		if(wid-start>maxW) {
			maxW = wid-start;
		}
		
		Collections.sort(cutHei);
		int maxH = 0;
		start = 0;
		for(int i=0;i<cutHei.size();i++) {
			if(cutHei.get(i)-start>maxH) {
				maxH = cutHei.get(i)-start;
			}
			start = cutHei.get(i);
		}
		if(hei-start>maxH) {
			maxH = hei-start;
		}
		
		bw.write(maxW*maxH+"");
		bw.flush();
		bw.close();
		
	}

}
