import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

	// 점심식사
	static List<Stair> stairs;
	static List<Person> persons;

	static class Stair{
		int x;
		int y;
		int cost;
		
		Queue<Integer> pq;
		
		public Stair(int x, int y, int cost) {
			this.x = x;
			this.y = y;
			this.cost = cost;
		}
		
		int calTime(Deque<Integer> dq) {
			pq = new PriorityQueue<>(dq);
			Queue<Integer> st = new ArrayDeque<>();
			
			int time = 0;
			while(!pq.isEmpty()) {
				int in = pq.poll() + 1;
				if (st.size() < 3) {
					st.add(in +cost);
				}else {
					int front = st.poll();
					if (front <= in) {
						st.add(in + cost);
					}else {
						st.add(front+cost);
					}
				}
			}
			
			while(!st.isEmpty()) time = st.poll(); 
			return time;
			
		}
	}
	static class Person{
		int x; 
		int y;
		
		public Person(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		int calDist(Stair s) {
			return Math.abs(s.x - this.x) + Math.abs(s.y - this.y);
		}
		
	}
	
	static int size, sol;
	
	static Deque<Integer> dq1;
	static Deque<Integer> dq2;
	
	static void make(int n) {
		if (n == size) {
			sol = Math.min(sol, Math.max(stairs.get(0).calTime(dq1), stairs.get(1).calTime(dq2)));
			return;
		}
		dq1.addLast(persons.get(n).calDist(stairs.get(0)));
		make(n+1);
		dq1.pollLast();
		
		dq2.addLast(persons.get(n).calDist(stairs.get(1)));
		make(n+1);
		dq2.pollLast();
	}
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			stairs = new ArrayList<>();
			persons = new ArrayList<>();
			
			int N = Integer.parseInt(br.readLine());
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				
				for (int j = 0; j < N; j++) {
					int temp = Integer.parseInt(st.nextToken());
					if (temp == 1) {
						persons.add(new Person(i,j));
					}else if (temp > 1){
						stairs.add(new Stair(i,j, temp));
					}
				}
			}
			dq1 = new ArrayDeque<>();
			dq2 = new ArrayDeque<>();

			size = persons.size();
			
			sol = Integer.MAX_VALUE;
			make(0); // 각 person index에 따라서 dq을 채우기
			
			System.out.printf("#%d %d\n", t, sol);
		}
		
	}

}
