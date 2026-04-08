class Solution {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
    int[] answer = new int[balls.length];
    
    for (int i = 0; i < balls.length; i++) {
        int a = balls[i][0], b = balls[i][1];
        int min = Integer.MAX_VALUE;
        
        // {대칭점x, 대칭점y, 예외x조건, 예외y조건}
        // 왼쪽 벽
        if (!(b == startY && a <= startX)) {
            int dx = -a - startX, dy = b - startY;
            min = Math.min(min, dx*dx + dy*dy);
        }
        // 오른쪽 벽
        if (!(b == startY && a >= startX)) {
            int dx = 2*m - a - startX, dy = b - startY;
            min = Math.min(min, dx*dx + dy*dy);
        }
        // 아래 벽
        if (!(a == startX && b <= startY)) {
            int dx = a - startX, dy = -b - startY;
            min = Math.min(min, dx*dx + dy*dy);
        }
        // 위 벽
        if (!(a == startX && b >= startY)) {
            int dx = a - startX, dy = 2*n - b - startY;
            min = Math.min(min, dx*dx + dy*dy);
        }
        
        answer[i] = min;
    }
    return answer;
}
}