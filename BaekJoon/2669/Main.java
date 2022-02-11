
/*

백준 2669 직사각형 네개 합집합 면적 구하기

 */



public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static boolean[][] check = new boolean[100][100];
	public static void main(String[] args) throws IOException{
		for(int t=0;t<4;t++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			for(int i=x1;i<x2;i++) {
				for(int j=y1;j<y2;j++) {
					check[i][j] = true;
				}
			}
		}
		
		int cnt = 0;
		for(int i=1;i<100;i++) {
			for(int j=1;j<100;j++) {
				if(check[i][j])
					cnt++;
			}
		}
		bw.write(String.format("%d", cnt));
		bw.flush();
		bw.close();
	}

}
