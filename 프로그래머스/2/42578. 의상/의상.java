import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        
        Map<String, Integer> map = new HashMap<>();
        
        int N = clothes.length;
        for (int i = 0; i < N; i++){
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
        }
        
        int ans = 1;
        if (map.size() == 1){
            for (Map.Entry<String, Integer> entry : map.entrySet()){
                return entry.getValue();
            }
        }
        // System.out.println(map);
        
        for (Map.Entry<String, Integer> entry : map.entrySet()){
            ans = ans * (entry.getValue() + 1);
        }
        
        return ans - 1;
    }
}