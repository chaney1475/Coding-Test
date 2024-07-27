import java.util.*;

public class Main {
    static class Pair {
        int position;
        int time;

        Pair(int position, int time) {
            this.position = position;
            this.time = time;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();

        Queue<Pair> q = new LinkedList<>();

        boolean[] visited = new boolean[100001];
        Arrays.fill(visited, false);
        q.add(new Pair(x, 0));
        visited[x] = true;

        while (!q.isEmpty()) {
            Pair now = q.poll();
            if (now.position == y) {
                System.out.println(now.time);
                return;
            }

            int[] nextPositions = {now.position - 1, now.position + 1, now.position * 2};

            for (int nextPos : nextPositions) {
                if (nextPos >= 0 && nextPos <= 100000 && !visited[nextPos]) {
                    q.add(new Pair(nextPos, now.time + 1));
                    visited[nextPos] = true;
                }
            }
        }
    }
}