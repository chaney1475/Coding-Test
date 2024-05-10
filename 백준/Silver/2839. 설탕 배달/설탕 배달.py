import sys
input = sys.stdin.readline

N = int(input())
dp = [sys.maxsize] * (N+1)
dp[0] = 0
for i in range(3,N+1,3):
    dp[i] = i // 3

for i in range(5,N+1):
    if dp[i-5] != sys.maxsize:
        dp[i] = dp[i-5] + 1
if dp[N] != sys.maxsize:
    print(dp[N])
else:
    print(-1)