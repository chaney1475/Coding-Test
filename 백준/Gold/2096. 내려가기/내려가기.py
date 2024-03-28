import sys

input = sys.stdin.readline

N = int(input())

dp = [[0, 0] for _ in range(3)]
new_dp = [[0, 0] for _ in range(3)]
A = []

for i in range(N):
    a,b,c = map(int, input().split())
    if i == 0:
        dp[0][0] = a
        dp[1][0] = b
        dp[2][0] = c

        dp[0][1] = a
        dp[1][1] = b
        dp[2][1] = c
        continue
    new_dp[0][0] = a + min(dp[0][0], dp[1][0])
    new_dp[1][0] = b + min(dp[0][0], dp[1][0], dp[2][0])
    new_dp[2][0] = c + min(dp[1][0], dp[2][0])

    new_dp[0][1] = a + max(dp[0][1], dp[1][1])
    new_dp[1][1] = b + max(dp[0][1], dp[1][1], dp[2][1])
    new_dp[2][1] = c + max(dp[1][1], dp[2][1])

    dp = [row[:] for row in new_dp]


mini = min(dp[0][0],dp[1][0],dp[2][0])
maxi = max(dp[0][1],dp[1][1],dp[2][1])
print(maxi,mini)