import java.util.*;

class Solution {
    public int solution(String my_string, String is_prefix) {
        if (is_prefix.length() > my_string.length()) {
            return 0;
        }
        
        String com = my_string.substring(0,is_prefix.length());
        return (com.equals(is_prefix)) ? 1:0;
    }
}