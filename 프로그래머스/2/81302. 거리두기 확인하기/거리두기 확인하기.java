import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static class Person {
        int x, y, dist;
        public Person(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        for (int i = 0; i < places.length; i++) {
            answer[i] = check_dist(places[i]);
        }
        return answer;
    }

    public int check_dist(String[] session) {
        int n = session.length;
        char[][] sits = new char[n][n];
        for (int i = 0; i < n; i++) {
            sits[i] = session[i].toCharArray();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (sits[i][j] == 'P') {
                    if (!isSafe(sits, n, i, j)) {
                        return 0;
                    }
                }
            }
        }
        return 1;
    }

    private boolean isSafe(char[][] sits, int n, int startX, int startY) {
        Queue<Person> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];
        queue.add(new Person(startX, startY, 0));
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            Person person = queue.poll();
            int x = person.x;
            int y = person.y;
            int dist = person.dist;

            if (dist > 0 && sits[x][y] == 'P') {
                return false;
            }

            if (dist >= 2) continue;

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if (nx >= 0 && nx < n && ny >= 0 && ny < n && !visited[nx][ny] && sits[nx][ny] != 'X') {
                    queue.add(new Person(nx, ny, dist + 1));
                    visited[nx][ny] = true;
                }
            }
        }

        return true;
    }
}