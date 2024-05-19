import sys
input = sys.stdin.readline

N = int(input())
T = [] # 걸리는 일수
P = [] # 받게되는 보상

for _ in range(N):
    t, p = map(int, input().split())
    T.append(t)
    P.append(p)

T.reverse()
P.reverse()

max_num = 0

dp = [0] * N

if T[0] == 1:
    dp[0] = P[0]
    max_num = dp[0]

for i in range(1,N):
    if i + 1 < T[i]:
        dp[i] = max_num
    else:
        dp[i] = max(dp[i - T[i]] + P[i], max_num)

    if dp[i] > max_num:
        max_num = dp[i]
print(max(dp))

