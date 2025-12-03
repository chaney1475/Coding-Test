import java.util.*;

class Solution {
    static int l, r;
    List<Integer> ans = new ArrayList<>();
    String[] nums = {"0", "5"};
    
    public int[] solution(int l, int r) {
        this.l = l;
        this.r = r;

        dfs("");

        if (ans.isEmpty()) return new int[]{-1};

        return ans.stream()
                .sorted()
                .mapToInt(i -> i)
                .toArray();
    }

    void dfs(String now) {
        if (!now.isEmpty()) {
            int num = Integer.parseInt(now);
            if (num > r) return;
            if (num >= l) ans.add(num);
        }

        if (now.length() > 10) return;

        for (String n : nums) {
            if (now.isEmpty() && n.equals("0")) continue;
            dfs(now + n);
        }
    }
}
