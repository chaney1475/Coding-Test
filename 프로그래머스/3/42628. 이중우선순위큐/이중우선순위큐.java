import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        TreeMap<Integer,Integer> map = new TreeMap<>();
        
        int N = operations.length;
        
        for (int i = 0; i < N; i++){
            String[] now = operations[i].split(" ");
            
            char op = now[0].charAt(0);
            int num = Integer.parseInt(now[1]);
            
            // op가 D인 경우 지우기, I인 경우 넣기
            if(op == 'I'){
                map.put(num, map.getOrDefault(num,0) + 1);
            }else{
                //제일 큰거 지우기
                if (map.size() == 0) continue;
                if (num == 1){
                    Map.Entry<Integer, Integer> big = map.lastEntry();
                    if (big.getValue() == 1) {
                        map.remove(big.getKey());
                    }else{
                        map.put(big.getKey(), big.getValue() - 1);
                    }
                }else{
                    // 작은거 지우기
                    Map.Entry<Integer, Integer> small = map.firstEntry();
                    if (small.getValue() == 1) {
                        map.remove(small.getKey());
                    }else{
                        map.remove(small.getKey() , small.getValue() - 1);
                    }
                }
                
                
            }
            
        }
        
        int big = 0;
        int small = 0;
        
        if (map.size() != 0){
            big = map.lastKey();
            small = map.firstKey();
        }
        
        return new int[]{big, small};
    }
}