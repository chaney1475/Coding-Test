import sys
input = sys.stdin.readline

N = int(input())
A = list(map(int, input().split()))
dp = [0] * N

dp[0] = A[0]
for i in range(1,N):
    if A[i] > dp[i-1] + A[i]:
        dp[i] = A[i]
    else:
        dp[i] = dp[i-1] + A[i]

print(max(dp))

