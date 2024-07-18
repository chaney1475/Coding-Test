

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
//import java.util.Queue;
//import java.util.LinkedList;

public class Main{
	
	static boolean[] isVisited;
	static int [][] map;
	static int count = 0;
	static int n,edge_num;
	
	//static Queue<Integer> q = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine()); // number of computer
		edge_num = Integer.parseInt(br.readLine()); // number of network
		
		map = new int[n][n];
		isVisited = new boolean[n];
		
		for (int i =0; i<edge_num;i++) {
			String networks = br.readLine();
			String []networksArray = networks.split(" ");
			
			int r = Integer.parseInt(networksArray[0]);
			int c = Integer.parseInt(networksArray[1]);
			
			map[r-1][c-1] = 1;
			map[c-1][r-1] = 1;
			
			
		}
		
		dfs(0);
		System.out.println(count-1);
		

	}
	public static void dfs(int start) {
		isVisited[start] = true;
		count++;
		
		for(int i=0; i<n; i++) {
			if (map[start][i]==1 && !isVisited[i]) {
				dfs(i);
			}
		}
	}

}
