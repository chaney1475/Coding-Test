import sys

input = sys.stdin.readline

#잔 갯수
N = int(input())

w = []

for _ in range(N):
    w.append(int(input()))


dp = [0] * (N+1)
dp[0] = w[0]
if N > 1:
    dp[1] = w[0] + w[1]
if N > 2:
    dp[2] = max(w[0] + w[2], w[1] + w[2],w[0]+w[1])

for i in range(3, N):
    dp[i] = max(dp[i-3] + w[i-1]+w[i],
                dp[i-2] + w[i],
                dp[i-1])

print(dp[N-1])

