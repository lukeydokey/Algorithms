package day11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*

백준 17143 낚시왕

 */

public class FishingKing {
	static class Shark {
		int r,c,s,d,z; // 위치, 속력 s, 방향 d, 크기 z

		public Shark(int r, int c, int s, int d, int z) {
			super();
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}
		
	}
	static StringTokenizer st;
	static int R, C, M, result;
	static ArrayList<Shark> list;
	static int [][] del = {
			{},
			{-1, 0},
			{1,0},
			{0,1},
			{0,-1}
	};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		list = new ArrayList<>();
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			list.add(new Shark(r,c,s,d,z));
		}
		
		fishingAt(1);
		System.out.println(result);
	}
	static void fishingAt(int col) {
		//땅과 제일 가까운 상어를 잡음
		int idx = -1;
		for(int i=0;i<list.size();i++) {
			if(list.get(i)==null)continue; // 잡힌 상어 제외
			if(list.get(i).c==col) {
				if(idx==-1) {
					idx = i;
				}else {
					if(list.get(i).r<list.get(idx).r) {
						idx = i;
					}
				}
			}
		}
		if(idx!=-1) { //잡은 상어가 있음
			Shark s = list.get(idx);
			result += s.z;
			list.set(idx, null);
		}
		
		if(col==C) //마지막 낚시 끝
			return;
		
		//상어가 이동함
		for(Shark s : list) {
			if(s==null)continue; //잡힌 상어는 스킵
			
			int move = s.s; // 상어가 이동할 거리
			int d = s.d; // 상어가 이동할 방향
			if(d<=2)
				move %= ((R-1)*2); //상하 이동
			else
				move %= ((C-1)*2); //좌우 이동
			int curR = s.r;
			int curC = s.c;
			while(move>0) {
				int nr = curR+del[d][0];
				int nc = curC+del[d][1];
				
				if(nr<1||nr>R||nc<1||nc>C) { //벽에 부딪히면 방향 전환
					if(d%2==0) {
						d--;
					}else
						d++;
					continue;
				}
				
				curR = nr;
				curC = nc;
				move--; //한칸 이동
			}
			
			s.r = curR;
			s.c = curC;
			s.d = d;
		}
		
		//같은 위치에 있는 상어 있으면 제거
		int[][] map = new int[R+1][C+1];
		for(int i=list.size()-1;i>=0;i--) {
			if(list.get(i)==null) continue; // 잡힌 상어 제외
			int curR = list.get(i).r;
			int curC = list.get(i).c;
			if(map[curR][curC]==0) {
				map[curR][curC] = i;
			}else { //같은 위치에 상어가 있음
				int curZ = list.get(i).z;
				int otherZ = list.get(map[curR][curC]).z;
				if(curZ>otherZ) {
					list.set(map[curR][curC], null);
					map[curR][curC] = i;
				}else {
					list.set(i, null);
					
				}
			}
		}
		
		fishingAt(col+1);
	}
}
