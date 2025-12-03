import java.math.*;
import java.util.*;

class Solution {
    public int solution(String num) {
        int sum = 0;

        for (int i = 0; i < num.length(); i++){
            sum += num.charAt(i) - '0';
        }

        int answer = sum % 9;
        return answer;
    }
}
