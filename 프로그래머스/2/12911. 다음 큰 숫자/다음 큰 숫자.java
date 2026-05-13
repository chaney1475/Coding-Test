class Solution {
    public int solution(int n) {
        int cnt = Integer.bitCount(n);

        int next = n + 1;

        while (true) {
            if (Integer.bitCount(next) == cnt) {
                return next;
            }
            next++;
        }
    }
}