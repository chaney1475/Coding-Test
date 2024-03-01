import sys
input = sys.stdin.readline

#갯수, 최대 무게
N, K = map(int, input().split())

w = [0]
v = [0]

for _ in range(N):
    a,b = map(int, input().split())
    w.append(a)
    v.append(b)

dp = [[0] * (1+K) for _ in range(N+1)]

for i in range(1, N+1):
    cur_w = w[i]
    cur_v = v[i]
    for j in range(1, K+1):
        if j - cur_w < 0:
            dp[i][j] = dp[i-1][j]
        else:
            dp[i][j] = max(dp[i-1][j], cur_v + dp[i-1][j-cur_w])

print(dp[N][K])