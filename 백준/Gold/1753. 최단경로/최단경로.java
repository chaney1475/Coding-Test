import java.io.*;
import java.util.*;

public class Main {

    static int V; // 노드의 수
    static int E; // 간선의 수

    static class Edge implements Comparable<Edge> {
        int x;
        long weight;

        Edge(int x, long weight) {
            this.x = x;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Long.compare(this.weight, o.weight);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();

        for (int i = 0; i < V + 1; i++) {
            graph.add(new ArrayList<>());
        }

        int start = Integer.parseInt(br.readLine());

        for (int e = 0; e < E; e++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long w = Long.parseLong(st.nextToken());

            graph.get(a).add(new Edge(b, w));
        }

        // 최소 거리 정보를 담을 배열 초기화
        long[] dist = new long[V + 1];
        Arrays.fill(dist, Long.MAX_VALUE);

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Edge current = pq.poll();
            int currentNode = current.x;
            long currentWeight = current.weight;

            // 현재 노드의 거리보다 긴 경우 무시
            if (currentWeight > dist[currentNode]) continue;

            for (Edge edge : graph.get(currentNode)) {
                long newDist = dist[currentNode] + edge.weight;

                if (newDist < dist[edge.x]) {
                    dist[edge.x] = newDist;
                    pq.add(new Edge(edge.x, newDist));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= V; i++) {
            if (dist[i] == Long.MAX_VALUE) {
                sb.append("INF\n");
            } else {
                sb.append(dist[i]).append("\n");
            }
        }

        System.out.print(sb.toString());
    }
}
