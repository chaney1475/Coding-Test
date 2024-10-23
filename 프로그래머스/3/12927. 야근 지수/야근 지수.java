import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int work : works) {
            maxHeap.offer(work);
        }
        
        while (n > 0 && !maxHeap.isEmpty()) {
            int largest = maxHeap.poll();
            if (largest > 0) {
                maxHeap.offer(largest - 1);
                n--;
            }
        }
        
        long total = 0;
        while (!maxHeap.isEmpty()) {
            int work = maxHeap.poll();
            total += (long) work * work;
        }
        
        return total;
    }
}
