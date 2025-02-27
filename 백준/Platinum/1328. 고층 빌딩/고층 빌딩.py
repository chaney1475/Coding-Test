import sys

input = sys.stdin.readline
n, l, r = map(int, input().split())
MOD = 1000000007

dp = [[[0 for _ in range(n+1)] for _ in range(n + 1)] for _ in range(n + 1)]

dp[1][1][1] = 1

for i in range(2, n + 1):
    for j in range(1, l + 1):
        for k in range(1, r + 1):
            dp[i][j][k] = dp[i - 1][j][k - 1] + dp[i - 1][j - 1][k] + (i - 2) * dp[i - 1][j][k]
            dp[i][j][k] %= MOD

print(dp[n][l][r])
