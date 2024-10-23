import java.util.*;class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        PriorityQueue<Integer> big = new PriorityQueue<>((a,b) -> b - a);
        int N = priorities.length;
        
        //제일 큰거 다음에 있는 그 다음 큰거 그 다음 큰거
        // 가장 큰걸 찾아서 list에 넣고 
        // 그 뒤에서부터 읽기
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        
        
        for (int i = 0; i < N; i++){
            big.add(priorities[i]);
            dq.addLast(new int[] {priorities[i], i});
        }
        
        for (int[] nn : dq){
                System.out.print(Arrays.toString(nn) + " ");
        }
        System.out.println();
        
        int idx = 1;
        while (!dq.isEmpty()){
            
            int now = big.poll();
            
            while(dq.peekFirst()[0] != now){
                dq.addLast(dq.pollFirst());
            }
            
            // 지금 이 상태는 peek()이 now인 경우
            int[] p = dq.pollFirst();
            if (p[1] == location){
                return idx;
            }
            
//             for (int[] nn : dq){
//                 System.out.print(Arrays.toString(nn) + " ");
//             }
            
//             System.out.println();
            idx++;
        }
        
        // System.out.println(big);
        return answer;
    }
}