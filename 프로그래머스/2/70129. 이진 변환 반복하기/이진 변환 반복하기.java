import java.util.*;
class Solution {
    public int[] solution(String s) {
        int zeroCnt = 0;
        int cnt = 0;


        while (!s.equals("1")){
            StringBuilder sb = new StringBuilder();

            for ( int i = 0; i < s.length(); i++){
                if (s.charAt(i) == '1'){
                    sb.append("1");
                }
            }

            zeroCnt += s.length() - sb.length(); // 원래 String 0이 제거된 String
            cnt ++;

            s = Integer.toBinaryString(sb.length());
        }



        return new int[]{cnt, zeroCnt};
    }
}