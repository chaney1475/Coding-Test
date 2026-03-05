import java.util.*;


class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        
        int n = id_list.length;
        
        int[] reportedCnt = new int[n];
        int[] answer = new int[n];
        
        Map<Integer, HashSet<Integer>> myReporters = new HashMap();
        Map<String, Integer> nameToIndex = new HashMap();
        
        // 이름 -> 인덱스 매핑
        for (int i = 0; i < n; i++) {
            nameToIndex.put(id_list[i], i);
        }
        
        for (int i = 0; i < report.length; i++) {
            String[] names = report[i].split(" ");
            int from = nameToIndex.get(names[0]);
            int to = nameToIndex.get(names[1]);
            
            HashSet<Integer> set = myReporters.getOrDefault(to, new HashSet<Integer>());
            if (!set.contains(from)) {
                set.add(from); // 날 신고한 사람을 추가
                reportedCnt[to]++;
                myReporters.put(to, set);
            }
        }
        
        for (int i = 0; i < n; i++) {
            // 신고를 k번 이상 당한 사람
            if (reportedCnt[i] >= k) {
                HashSet<Integer> set = myReporters.get(i);
                for (Integer reporter : set) {
                    answer[reporter]++;
                }
            }
        }
        
        return answer;
    }
}