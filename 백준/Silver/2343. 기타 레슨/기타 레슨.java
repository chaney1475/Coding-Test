import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[] nums;
    static int N, M;

    static boolean func(long maxBluRaySize) {
        long sum = 0;
        int cnt = 1;  // 블루레이 개수를 세기 위한 변수

        for (int i = 0; i < N; i++) {
            if (sum + nums[i] > maxBluRaySize) {
                cnt++;
                sum = 0;
            }
            sum += nums[i];
        }
        
        return cnt <= M; // 블루레이가 M개 이하로 분할이 가능한지
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        nums = new int[N];

        st = new StringTokenizer(br.readLine());
        long maxLectureLength = 0;
        long totalSum = 0;
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            maxLectureLength = Math.max(maxLectureLength, nums[i]); // 가장 긴 강의의 길이
            totalSum += nums[i]; // 모든 강의 길이의 합
        }

        long start = maxLectureLength; // 블루레이 크기의 최소값은 가장 긴 강의의 길이
        long end = totalSum; // 블루레이 크기의 최대값은 모든 강의를 한 블루레이에 담는 경우

        while (start < end) {
            long mid = (start + end) / 2;

            if (func(mid)) {
                end = mid; // M개의 블루레이로 나눌 수 있다면, 더 작은 크기를 시도
            } else {
                start = mid + 1; // 나눌 수 없다면, 더 큰 크기를 시도
            }
        }

        System.out.println(start); // 가능한 최소 블루레이 크기 출력
    }
}
