import java.util.*;
import java.io.*;

public class Main {
	static class Point{
		int x,y;
		
		Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	static int N;
	
	static Point[] list;
	
	static int[][] dist;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int convi = Integer.parseInt(br.readLine());
			N = convi + 2;
			
			list = new Point[N];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				list[i] = new Point(a,b); 
			}
			
			
			dist = new int[N][N];

			for (int i = 0; i < N; i++) {
				Arrays.fill(dist[i], Integer.MAX_VALUE);
			}
			
			// 초기화
			for (int i = 0; i < N; i++) {// 간선은 모두 구하면 됨
				for (int j = 0; j < N; j++) {
					if (i != j) {
						int d = calDist(list[i] , list[j]);
						if (d <= 1000) {
							dist[i][j] = d;
							dist[j][i] = d;
						}
					}else {
						dist[i][j] = 0;
					}
				}
			}
			
			makeDist();

			// 0에서 N-1까지 나온 최소 거리
			if (dist[0][N-1] == Integer.MAX_VALUE) {
				System.out.println("sad");
			}else {
				System.out.println("happy");
			}
			
		}
	}
	
	static int calDist(Point p1, Point p2) {
		return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
	}
	
	static void makeDist() {
		
		for (int k = 0; k < N; k ++) {
			for (int i = 0; i < N; i ++) {
				for (int j = 0; j < N; j++) {
					//하나의 간선이 나왔음
					if (dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE) {
						dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
					}
				}
			}
		}
		
		
	}

}