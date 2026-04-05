import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        ArrayList<String> list = new ArrayList<>();
        
        for (int i = 0; i < numbers.length; i++) {
            list.add(String.valueOf(numbers[i]));
        }
        
        list.sort((a,b) -> (b+a).compareTo(a+b));
        
        if (list.get(0).equals("0")) {
            return "0";
        }
        
        StringBuilder sb = new StringBuilder();
        
        for (String l : list) {
            sb.append(l);
        }
        return sb.toString();
    }
}