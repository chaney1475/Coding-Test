class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        String sa = String.valueOf(a);
        String sb = String.valueOf(b);
        
        int r1 = Integer.valueOf(sa+sb);
        int r2 = a * b * 2;
        return (r1 > r2) ? r1 : r2;
    }
}