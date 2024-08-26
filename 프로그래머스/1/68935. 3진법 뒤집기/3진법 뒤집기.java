import java.util.*;

class Solution {
    public int solution(int n) {
        List<Integer> list = new ArrayList<>();

        while ( n / 3 != 0){
            list.add(n % 3);
            n = n / 3;
        }
        list.add(n);

        int answer = 0;
        int multi = 1;

        for (int i = list.size() - 1; i >= 0; i--){
            answer += list.get(i) * multi;
            multi *= 3;
        }
        return answer;
    }
}