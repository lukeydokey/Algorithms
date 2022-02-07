import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 15649번 N과M

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static int N, M;
	static int[] numbers;
	static boolean [] isSelected;
	public static void main(String[] args) throws IOException{
		String str = br.readLine();
		String [] line = str.split(" ");
		
		N = Integer.parseInt(line[0]);
		M = Integer.parseInt(line[1]);
		numbers = new int[M];
		isSelected = new boolean[N];
		
		
		func(0);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
	static void func(int cnt){
		
		if(cnt==M) {
			for(int i=0;i<M;i++) {
				if(i==M-1)
					sb.append(numbers[i]);
				else
					sb.append(numbers[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		else {
			for(int i=0;i<N;i++) {
				if(isSelected[i]) continue;
				numbers[cnt] = i+1;
				isSelected[i] = true;
				func(cnt+1);
				isSelected[i] = false;
				
			}
		}
	}
}