import sys
from collections import deque
input = sys.stdin.readline

N = int(input())

A = []
for i in range(N):
    A.append(list(map(int, input().split())))

dp = [[[0,0,0] for _ in range(N)] for _ in range(N)]

dp[0][1][0] = 1

for i in range(2,N):
    if A[0][i] == 0:
         dp[0][i][0] = dp[0][i-1][0]



for i in range(1, N):
    for j in range(1, N):
        if A[i][j] == 1:
            continue

        dp[i][j][0] = dp[i][j-1][0] + dp[i][j-1][2]
        dp[i][j][1] = dp[i-1][j][1] + dp[i-1][j][2]

        if A[i-1][j] == 0 and A[i][j-1] == 0:
            dp[i][j][2] = sum(dp[i-1][j-1])


print(sum(dp[N-1][N-1]))