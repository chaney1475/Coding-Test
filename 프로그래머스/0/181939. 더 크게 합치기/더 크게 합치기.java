class Solution {
    public int solution(int a, int b) {
        String A = String.valueOf(a);
        String B = String.valueOf(b);
        
        int q = Integer.valueOf(A + B);
        int w = Integer.valueOf(B + A);
        
        return (q > w) ? q : w;
    }
}