import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*

백준 7568 덩치

*/

public class BigMan {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        int[][] man = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            man[i][0] = Integer.parseInt(st.nextToken()); // 몸무게
            man[i][1] = Integer.parseInt(st.nextToken()); // 키
        }

        int[] rank = new int[N];
        for (int i = 0; i < N; i++) {
            int r = 1; // 랭크
            for (int j = 0; j < N; j++) {
                if (i == j)
                    continue;
                if (man[i][0] < man[j][0] && man[i][1] < man[j][1])
                    r++;
            }
            rank[i] = r;
        }

        for (int i : rank) {
            bw.write(i + " ");
        }
        bw.flush();
        bw.close();

    }

}