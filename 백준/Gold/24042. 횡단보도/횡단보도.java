import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static List<List<Node>> adj;
    static long[] dist;

    static class Node implements Comparable<Node> {
        int idx;
        long cost;

        Node(int idx, long cost) {
            this.idx = idx;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Long.compare(this.cost, o.cost);
        }
    }

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adj = new ArrayList<>();
        dist = new long[N + 1];
        Arrays.fill(dist, Long.MAX_VALUE);

        for (int i = 0; i <= N; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            adj.get(A).add(new Node(B, i));
            adj.get(B).add(new Node(A, i));
        }

        System.out.println(dijkstra());
    }

    private static long dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(1, 0));
        dist[1] = 0;

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            int node = now.idx;
            long time = now.cost;

            if (node == N) return time;

            if (dist[node] < time) continue;

            for (Node next : adj.get(node)) {
                int nextNode = next.idx;
                long signalIndex = next.cost;
                long waitTime = 0;

                if (time % M <= signalIndex) {
                    waitTime = signalIndex - (time % M);
                } else {
                    waitTime = M - (time % M - signalIndex);
                }

                long nextTime = time + waitTime + 1;

                if (nextTime < dist[nextNode]) {
                    dist[nextNode] = nextTime;
                    pq.add(new Node(nextNode, nextTime));
                }
            }
        }
        return -1; // 도달 불가능한 경우
    }
}
