
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/*

백준 18870 좌표 압축
N개의 좌표
정렬
순위 정함
예)
5
2 4 -10 4 -9
결과 :
2 3 0 3 1

*/



public class Main {
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int [] p = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0;i<N;i++) {
			p[i] = Integer.parseInt(st.nextToken());
		}
		
		int [] sortedP = p.clone();
		Arrays.sort(sortedP);
		
		Map<Integer, Integer> map = new HashMap<>();
		int cnt=0;
		for(int i=0;i<N;i++) {
			if(!map.containsKey(sortedP[i])) {
				map.put(sortedP[i], cnt++);
			}
		}
		
		for(int i=0;i<N;i++) {
			p[i] = map.get(p[i]);
		}
		
		for(int i=0;i<N;i++) {
			bw.write(String.format("%d ", p[i]));
		}
		bw.write("\n");
		bw.flush();
		bw.close();
	}

}