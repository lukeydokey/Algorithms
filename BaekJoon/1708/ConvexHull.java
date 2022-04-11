package day9;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Stack;
import java.util.StringTokenizer;

/*

백준 1708 블록 껍질

*/

public class ConvexHull {
	
	static class Point{
		long x;
		long y;
		public Point(long x, long y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	
	static int N;
	public static void main(String[] args) throws IOException{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
	    N = Integer.parseInt(br.readLine());
	    ArrayList<Point> points = new ArrayList<>();
	    Stack<Point> hull = new Stack<>();
	    for(int i=0;i<N;i++) {
	    	StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	    	int x = Integer.parseInt(st.nextToken());
	    	int y = Integer.parseInt(st.nextToken());
	    	
	    	points.add(new Point(x, y));
	    }
	    
	    points.sort(new Comparator<Point>() {
	    	@Override
	    	public int compare(Point p1, Point p2) {
	    		if(p1.y==p2.y) {
	    			if(p1.x<p2.x)
	    				return -1;
	    			else
	    				return 1;
	    		}else 
	    			return (int)(p1.y - p2.y);
	    	}
	    });
	    
	    Point first = points.remove(0); // 시작 점 선택
	    
	    points.sort(new Comparator<Point>() { // 시작 점 기준 반시계방향 , 거리 짧은순 정렬

			@Override
			public int compare(Point p1, Point p2) {
				int ccw = getCCW(first,p1,p2);
				if(ccw==0) {
					long dis1 = getDis(first, p1);
					long dis2 = getDis(first, p2);
					
					if(dis1>dis2)
						return 1;
					else
						return -1;
				}
				else {
					return ccw > 0 ? -1 : 1;
				}
			}
	    });
	    
	    // Graham's Scan Algorithm
	    hull.push(first);
	    hull.push(points.remove(0));
	    for(int i=0;i<N-2;i++) {
	    	Point t = points.get(i);
	    	while(hull.size()>=2) {
	    		Point s = hull.pop();
	    		Point f = hull.peek();
	    		
	    		int result = getCCW(f,s, t); //first second third 
	    		if(result>0) {
	    			hull.push(s);
	    			break;
	    		}
	    	}
	    	hull.push(t);
	    }
	    
	    bw.write(hull.size()+"");
	    bw.flush();
	    bw.close();
	    
	}
	static int getCCW(Point first, Point p1, Point p2) {
		Point vec1 = new Point(p1.x-first.x, p1.y-first.y); // vector ( first -> p1 )
		Point vec2 = new Point(p2.x-p1.x, p2.y-p1.y); 		// vector ( p1 -> p2 )
		long result = vec1.x*vec2.y - vec1.y*vec2.x; // 두 벡터 외적
		if(result > 0) { // 반시계
			return 1;
		}else if(result < 0) {
			return -1;
		}else {
			return 0;
		}
			
	}
	static long getDis(Point p1, Point p2) {
        return (p2.x - p1.x) * (p2.x - p1.x) + (p2.y - p1.y) * (p2.y - p1.y);
	}
}
