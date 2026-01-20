
class Solution {
    public String solution(String[] survey, int[] choices) {
        StringBuilder answer = new StringBuilder();
        int n = survey.length;
        
        int[] cnt = new int[26];
        
        for (int i = 0; i< n; i++) {
            int score = choices[i];
            String cur = survey[i];
            
            char c1 = cur.charAt(0);
            char c2 = cur.charAt(1);
            
            if (score <= 3) {
                cnt[c1-'A'] += 4 - score;
            } else if (score > 4) {
                cnt[c2 -'A'] += score - 4;
            }
        }
        
        int R = cnt['R' - 'A'];
        int T = cnt['T' - 'A'];
        // T가 먼저
        
        if (R >= T) {
            answer.append("R");
        } else {
            answer.append("T");
        }
        
        int C = cnt['C' - 'A'];
        int F = cnt['F' - 'A'];
        if (C >= F) {
            answer.append("C");
        } else {
            answer.append("F");
        }
        // C가 먼저
        
        int J = cnt['J' - 'A'];
        int M = cnt['M' - 'A'];
        // J가 먼저
        if (J >= M) {
            answer.append("J");
        } else {
            answer.append("M");
        }
        
        int A = cnt['A' - 'A'];
        int N = cnt['N' - 'A'];
        
        // A가 먼저
        if (A >= N) {
            answer.append("A");
        } else {
            answer.append("N");
        }
        
        return answer.toString();
    }
}