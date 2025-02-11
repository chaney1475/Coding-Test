import java.util.*;
class Solution {
    public String[] solution(String[] strings, int n) {
        int N = strings.length;
        String[] answer = new String[N];
        
        // ArrayList<String> list = new ArrayList<>();
        
        // for(int i = 0; i < N; i++){
        //     list.add(strings[i]);
        // }
        
        Arrays.sort(strings,
                    (a,b) -> {
                        if (a.charAt(n) != b.charAt(n))
                            return a.charAt(n) - b.charAt(n);
                        else 
                            return a.compareTo(b);
                    }
        );
        
        // System.out.println(list);
        // for(int i = 0; i < N; i++){
        //     answer[i] = list.get(i);
        // }
        
        return strings;
    }
}