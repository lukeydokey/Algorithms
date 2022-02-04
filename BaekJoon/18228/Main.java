import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); // 얼음 갯수
		int [] ice = new int[2000000];
		int peng = 0;
		String str = br.readLine();
		String [] line = str.split(" ");
		for(int i=0;i<n;i++) {
			ice[i] = Integer.parseInt(line[i]);
		}
		
		for(int i=0;i<n;i++) {
			if(ice[i]==-1)
				peng = i;
		}
		
		int min = Integer.MAX_VALUE;
		int left = 0;
		int right = 0;
		
		for(int i=0;i<peng;i++) {
			if(min>ice[i]) {
				min = ice[i];
				left = i;
			}
		}
		
		min = Integer.MAX_VALUE;
		for(int i=peng+1;i<n;i++) {
			if(min>ice[i]) {
				min = ice[i];
				right = i;
			}
		}
		
		System.out.println(ice[left]+ice[right]);
		
		
		
	}

}
