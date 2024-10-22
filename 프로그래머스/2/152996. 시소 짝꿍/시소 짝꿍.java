import java.util.*;

class Solution {
    
    Map<Integer, Integer> map;
    
    public long solution(int[] weights) {
        long answer = 0;
        map = new HashMap<>();
        
        int N = weights.length;
        
        for (int i = 0; i < N; i++){
            map.putIfAbsent(weights[i], 0);
            map.put(weights[i], map.get(weights[i]) + 1);
        }
        
        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
            //1개 이상인경우에는 
            
            if (entry.getValue() > 1){
                //나 자신과 하기
                answer += (long)entry.getValue() * (long)( entry.getValue() - 1) / 2;
            }
            
            List<Integer> list = makeList(map, entry.getKey());
            
            for (Integer pos : list){
                //있는 경우에는 곱하기!
                if (map.containsKey(pos)){
                    answer += (long) map.get(pos) * (long) entry.getValue();
                }
            }
        }
        
        return answer;
    }
    
    List<Integer> makeList(Map<Integer, Integer> map, Integer key){
        //각각 확인하기
        List<Integer> answer = new ArrayList<>();
        
        if (map.containsKey(key * 2)){
            answer.add(key * 2);
        }
        if (key % 2 == 0 && map.containsKey(key / 2 * 3)){
            answer.add( key / 2 * 3);
        }
        if (key % 3 == 0 && map.containsKey(key / 3 * 4)) {
            answer.add( key / 3 * 4);
        }
        
        return answer;
    }
    
}