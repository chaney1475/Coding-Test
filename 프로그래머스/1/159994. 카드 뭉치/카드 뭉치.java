import java.util.*;
class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        
        int G = goal.length;
        int c1Len = cards1.length;
        int c2Len = cards2.length;
        
        int c1 = 0;
        int c2 = 0;
        
        if (c1Len + c2Len < G) {
            return "No";
        }
        
        int i = 0;
        while (i < G) {
            
            // 현재 스트링
            String curStr = goal[i];
            
            // 각각의 현재 스트링
            if (c1 < c1Len && cards1[c1].equals(curStr)) {
                i++;
                c1++;
            } else if ( c2 < c2Len && cards2[c2].equals(curStr)) {
                i++;
                c2++;
            } else {
                return "No";
            }
        }
        
        return "Yes";
    }
}