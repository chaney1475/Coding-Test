import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int N = enroll.length;
        Map<String, Integer> nameIdx = new HashMap<>(); // 이름 -> 인덱스 매핑
        int[] answer = new int[N]; // 최종
        int[] parent = new int[N]; // 추천인
        
        for (int i = 0; i < N; i++) {
            nameIdx.put(enroll[i], i);
        }
        
        for (int i = 0; i < N; i++) {
            if (referral[i].equals("-")) {
                parent[i] = -1;
            } else {
                parent[i] = nameIdx.get(referral[i]);
            }
        }
        
        // 판매 이익 계산
        for (int i = 0; i < seller.length; i++) {
            int curIdx = nameIdx.get(seller[i]);
            int profit = amount[i] * 100; // 개당 100원
            
            while (curIdx != -1 && profit > 0) {
                int parentProfit = profit / 10; // 10% 배분
                answer[curIdx] += profit - parentProfit; // 자신이 가져갈 이익
                
                // 상위 조직으로 이동
                profit = parentProfit;
                curIdx = parent[curIdx];
            }
        }
        
        return answer;
    }
}