import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0,1, 0, -1};
    static boolean[][] visited;
    static Queue<Person> queue = new LinkedList<>();

    static class Person{
        int x;
        int y;
        int dist = 0;
        public Person(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        int idx = 0;
        for (String[] place : places) {
            answer[idx++] = check_dist(place);
        }
        return answer;
    }

    public int check_dist(String[] session) {

        char[][] sits = new char[session.length][session[0].length()];

        for (int i = 0; i < session.length; i++) {
            sits[i] = session[i].toCharArray();
        }

        for (int i = 0; i < session.length; i++) {
            System.out.println(Arrays.toString(sits[i]));
        }
        System.out.println();

        for(int i = 0; i < sits.length; i++) {
            for(int j = 0; j < sits[0].length; j++) {
                if(sits[i][j] == 'P'){ // 사람일때
                    visited = new boolean[sits.length][sits[0].length];

                    queue.clear();
                    queue.add(new Person(i,j,0)); // 확인
                    visited [i][j] = true;


                    while(! queue.isEmpty()){
                        Person person = queue.poll();
                        int x = person.x;
                        int y = person.y;
                        int dist = person.dist;

                        if(dist > 0 && dist <= 4 && sits[x][y]== 'P')
                            return 0;

                        for(int k = 0; k < 4; k++) {
                            int nx = person.x + dx[k];
                            int ny = person.y + dy[k];
                            int newD = person.dist + 1;
                            if (nx >=0 && nx < sits.length && ny >= 0 && ny < sits[0].length && newD <= 2 && sits[nx][ny] != 'X' && !visited[nx][ny]){
                                queue.add(new Person(nx,ny,newD));
                                visited[nx][ny] = true;
                            }
                        }

                    }

                }
            }
        }

        return 1;
    }
}
