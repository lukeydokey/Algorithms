import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		double [] result = new double[1000];
		int [] score = new int[1000];
		
		
		for(int i=0;i<tc;i++) {
			int st1 = 0;
			int student = sc.nextInt();
			int sum = 0;
			for(int j=0;j<student;j++) {
				score[j] = sc.nextInt();
				sum += score[j];
			}
			
			double avg = (double) sum / student;
			for(int j=0;j<student;j++) {
				if(avg < score[j])
					st1++;
			}
			
			result[i] = (double) st1 / student;
			
		}
		
		for(int i=0; i<tc;i++) {
			System.out.printf("%.3f%%\n", result[i]*100);
		}
		
	}

}