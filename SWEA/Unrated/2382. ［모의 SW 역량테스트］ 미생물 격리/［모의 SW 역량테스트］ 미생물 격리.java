import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    static int[] dx = {-1, 1, 0, 0}; // 상하좌우
    static int[] dy = {0, 0, -1, 1};

    static int N, K, M;

    static class Microbe implements Comparable<Microbe> {
        int x, y, count, dir;

        Microbe(int x, int y, int count, int dir) {
            this.x = x;
            this.y = y;
            this.count = count;
            this.dir = dir;
        }

        void move() {
            this.x += dx[dir];
            this.y += dy[dir];

            if (x == 0 || x == N - 1 || y == 0 || y == N - 1) {
                count /= 2; // 미생물 수 반감
                dir = (dir % 2 == 0) ? dir + 1 : dir - 1; // 방향 반전
            }
        }

        @Override
        public int compareTo(Microbe other) {
            return other.count - this.count; // 내림차순 정렬 (큰 수부터)
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            List<Microbe> microbes = new ArrayList<>();

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int count = Integer.parseInt(st.nextToken());
                int dir = Integer.parseInt(st.nextToken()) - 1;

                microbes.add(new Microbe(x, y, count, dir));
            }

            // M 시간 동안 미생물 이동
            for (int m = 0; m < M; m++) {
                Map<String, PriorityQueue<Microbe>> map = new HashMap<>();

                for (Microbe microbe : microbes) {
                    microbe.move();

                    if (microbe.count > 0) {
                        String key = microbe.x + "," + microbe.y;
                        map.putIfAbsent(key, new PriorityQueue<>());
                        map.get(key).add(microbe);
                    }
                }

                // map을 통해 microbes 리스트 갱신
                microbes.clear();
                for (PriorityQueue<Microbe> pq : map.values()) {
                    Microbe merged = pq.poll(); // 가장 큰 군집을 꺼냄
                    while (!pq.isEmpty()) {
                        Microbe next = pq.poll();
                        merged.count += next.count; // 병합
                    }
                    microbes.add(merged); // 병합된 군집을 추가
                }
            }

            int answer = microbes.stream().mapToInt(m -> m.count).sum();
            System.out.printf("#%d %d\n", t, answer);
        }
    }
}