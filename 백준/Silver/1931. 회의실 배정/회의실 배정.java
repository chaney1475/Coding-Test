import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Meeting implements Comparable<Meeting>{
    int a;
    int b;

    Meeting(int a, int b){
        this.a = a;
        this.b = b;
    }

    @Override
    public int compareTo(Meeting o) {
        if (this.b != o.b) {
            return Integer.compare(this.b, o.b);
        }
        return Integer.compare(this.a, o.a);
    }
}

public class Main {
    static int N;
    static List<Meeting> meetings = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        //회의실
        //N개의 회의실
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i< N; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            meetings.add(new Meeting(a, b));
        }
        Collections.sort(meetings);

        int cnt = 1;
        int last = meetings.get(0).b;

        for (int i = 1; i < N; i++){
            if (meetings.get(i).a >= last){
                cnt++;
                last = meetings.get(i).b;
            }
        }
        System.out.println(cnt);

    }
}
