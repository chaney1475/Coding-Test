import sys

input = sys.stdin.readline

N, K = map(int, input().split())

bag = []
for _ in range(N):
    bag.append(list(map(int, input().split())))

dp = [[0] * (K+1) for _ in range(N)]

w,v = bag[0]
for i in range(w, K+1):
    dp[0][i] = v

for i in range(1,N):
    W,V = bag[i]
    for j in range(1,K+1):
        if j < W:
            dp[i][j] = dp[i-1][j]
        else:
            dp[i][j] = max(dp[i - 1][j - W] + V, dp[i - 1][j])

print(max(dp[N-1]))