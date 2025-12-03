import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        int i = 0;
        List<Integer> l = new ArrayList<>();
        
        int s = arr.length;
        
        while (i < s){
            
            if (l.isEmpty()){
                l.add(arr[i]);
                i++;
                continue;
            }
            int last = l.get(l.size() - 1);
            if (last < arr[i]){
                l.add(arr[i]);
                i++;
            }else{
                l.remove(l.size() - 1);
            }
        }
        return l.stream().mapToInt(a -> a).toArray();
    }
}