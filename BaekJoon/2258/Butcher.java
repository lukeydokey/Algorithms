package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*

백준 2258 정육점

 */

public class Butcher {
	
	static class Meat implements Comparable<Meat>{
		int weight;
		int price;
		public Meat(int weight, int price) {
			super();
			this.weight = weight;
			this.price = price;
		}
		
		@Override
		public int compareTo(Meat o) {
			if(price==o.price) {
				return Integer.compare(o.weight, weight);
			}
			return Integer.compare(price, o.price);
		}
		
		
	}
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Meat> pq = new PriorityQueue<>();
		for(int i=0;i<n;i++) {
			st= new StringTokenizer(br.readLine(), " ");
			int w = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			
			pq.offer(new Meat(w, p));
		}
		
		int result = 0;
		int curPrice = 0;
		long sumWeight = 0;
		boolean flag = false;
		while(!pq.isEmpty()) {
			Meat meat = pq.poll();
			
			int curWeight = meat.weight;
			
			if(flag) {//구매 가능 상태에서 같은 가격 여러개 사는거와 더 비싼거 하나 사는거 중 뭐가 싼지 비교
				if(curPrice<meat.price) { //더 비싼거와 비교
					if(result>meat.price) { //더 비싼거 하나 사는게 쌈
						result = meat.price;
					}
					break;
				}else {
					continue;
				}
			}
			else { //아직 구매 수량 부족
				if (curPrice < meat.price) { // 다른 가격의 고기
					result = 0;
					curPrice = meat.price;
				} else { //같은 가격 고기
					result += meat.price;
				}
			}
			
			if(sumWeight+curWeight>=m) { // 필요한 만큼 도달
				if(result==0) { //현재 고기만 사고 나머진 덤으로 얻음
					result = meat.price;
					flag = true; // 구매 가능
					break;
				}else { //가격 같은 고깃덩이가 여러개
					result += meat.price;
					flag = true; // 구매 가능
					//같은 가격 여러개 사는거랑 더 비싼거 하나 사는거 뭐가 싼지 비교해야함
					continue;
				}
			}else { //구매에 필요한 양보다 적음
				sumWeight += curWeight;
			}
			
			
		}
		
		if(flag) { //구매 가능
			bw.write(result+"");
		}else {
			bw.write("-1");
		}
		bw.flush();
		bw.close();
		
	}

}
