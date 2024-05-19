import sys
input = sys.stdin.readline

N = int(input())
A = list(map(int, input().split()))
dp = [a for a in A]
for i in range(1, N):
    for j in range(i):
        if A[j] < A[i]:
            dp[i] = max(dp[i], dp[j] + A[i])
print(max(dp))