import java.util.*;

class Solution {
    public String solution(int[] food) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < food.length; i++){
            for (int j = 0; j < food[i] / 2; j++) {
                sb.append(i);
            }
        }
        
        StringBuilder reverse = new StringBuilder(sb).reverse();
        sb.append(0).append(reverse);
        
        return sb.toString();
    }
}