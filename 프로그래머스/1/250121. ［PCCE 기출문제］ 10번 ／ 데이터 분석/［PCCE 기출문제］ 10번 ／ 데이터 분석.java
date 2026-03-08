import java.util.*;
// [3,20300401,10,8]
// 이전 날짜 빼고
// 
class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int[][] answer = {};
        
        int index = -1;
        Map<String, Integer> map = new HashMap<>();
        map.put("code", 0);
        map.put("date", 1);
        map.put("maximum", 2);
        map.put("remain", 3);
        
        int extIndex = map.get(ext);
        int sort_byIndex = map.get(sort_by);
        
        int dataLen = data.length;
        
        List<int[]> list = new ArrayList<int[]>();
        
        for (int i = 0; i < dataLen; i++) {
            if (data[i][extIndex] < val_ext) {
                list.add(data[i]);
            }
        }
        
        list.sort((a, b) -> {
            return a[sort_byIndex] - b[sort_byIndex];
        });

        return list.toArray(new int[list.size()][]);
    }
}