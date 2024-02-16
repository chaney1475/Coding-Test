import sys
input = sys.stdin.readline

N = int(input())
P = list(map(int,input().split()))

dp = [0] * (1000+1)

for i in range(N):
    dp[i+1] = P[i]

for i in range(2, N+1):
    for j in range(1,i):
        dp[i] = max(dp[i], dp[j] + P[i-j-1])

print(dp[N])