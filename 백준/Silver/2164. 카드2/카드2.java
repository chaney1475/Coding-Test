import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Deque<Integer> deque = new ArrayDeque<>();
		
		for (int i = 0; i < N; i++) {
			deque.add(i+1);
		}
		while (deque.size() > 1) {
			deque.pollFirst();
			deque.addLast(deque.pollFirst());
		}
		
		System.out.println(deque.poll());
		
	}

}