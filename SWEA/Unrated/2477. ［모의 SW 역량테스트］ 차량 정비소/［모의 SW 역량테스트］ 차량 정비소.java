import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int A, B, C; // 접수, 정비, 사람 갯수

	static int[] a;
	static int[] b;

	static int ansA; // 지갑을 두고간 사람이 간 접수차욱
	static int ansB; // 지갑을 두고간 사람이 간 정비 창구 번호

	static Deque<Person> waitRecept;
	static Deque<Person> waitFix;
	static Person[] recepting;
	static Person[] fixing;

	static int sum;

	static class Person {
		int id;
		int time;
		int recept;
		int fix;

		public Person(int id, int time) {
			this.id = id;
			this.time = time;
		}

	}

	public static void main(String[] args) throws IOException {
		// 차량정비소
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			init();
			sum = 0;
			int time = -1, rCnt = 0, wCnt = 0;
			while (!waitRecept.isEmpty() || !waitFix.isEmpty() || rCnt > 0 || wCnt > 0) {
				time++; // 시간 증가

				for (int i = 0; i < B; i++) {
					if (fixing[i] == null)
						continue;
					else if (fixing[i].time == time) { // 현재 시간에 도달한 고객
						if (fixing[i].fix == ansB && fixing[i].recept == ansA)
							sum += fixing[i].id;
						fixing[i] = null;
						wCnt--;
					}
				}
				for (int i = 0; i < A; i++) {
					if (recepting[i] == null)
						continue;
					else if (recepting[i].time == time) {
						waitFix.add(recepting[i]);
						recepting[i] = null;
						rCnt--;
					}
				}

				while (rCnt < A && !waitRecept.isEmpty() && waitRecept.peek().time <= time) {
					for (int i = 0; i < A; i++) {
						if (recepting[i] == null) {
							rCnt++;
							recepting[i] = waitRecept.poll();
							recepting[i].time = time + a[i];
							recepting[i].recept = i + 1;
						}
						if (waitRecept.isEmpty() || waitRecept.peek().time > time)
							break;
					}
				}

				while (wCnt < B && !waitFix.isEmpty() && waitFix.peek().time <= time) {
					for (int i = 0; i < B; i++) {
						if (fixing[i] == null) {
							wCnt++;
							fixing[i] = waitFix.poll();
							fixing[i].time = time + b[i];
							fixing[i].fix = i + 1;
						}
						if (waitFix.isEmpty() || waitFix.peek().time > time)
							break;
					}
				}
			}

			System.out.printf("#%d %d\n", t, sum == 0 ? -1 : sum);

		}

	}

	private static void init() throws IOException {
		st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken()); // 접수 창구 갯수
		B = Integer.parseInt(st.nextToken()); // 정비 창구 갯수

		C = Integer.parseInt(st.nextToken()); // 사람수

		ansA = Integer.parseInt(st.nextToken());// 지갑을 두고간 사람의 접수번호
		ansB = Integer.parseInt(st.nextToken());// 창구번호

		a = new int[A];
		b = new int[B];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < A; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < B; i++) {
			b[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());

		waitRecept = new ArrayDeque<>(); // 접수 기다리는 큐
		waitFix = new ArrayDeque<>(); // 정비 기다리는 큐

		recepting = new Person[A]; // 이용중인 접수
		fixing = new Person[B]; // 이용중인 정비

		for (int i = 0; i < C; i++) {
			int tempc = Integer.parseInt(st.nextToken());
			waitRecept.add(new Person(i + 1, tempc));
		}
	}

}
