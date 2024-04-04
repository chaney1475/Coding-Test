import sys
input = sys.stdin.readline

T = int(input())



for _ in range(T):
    N = int(input())

    dp = [[0] * N for _ in range(2)]
    A = [list(map(int,input().split())) for _ in range(2)]

    dp[0][0] = A[0][0]
    dp[1][0] = A[1][0]

    if N > 1:
        dp[0][1] = A[0][1] + A[1][0]
        dp[1][1] = A[1][1] + A[0][0]

    for i in range(2, N):
        dp[0][i] = A[0][i] + max(dp[1][i-1],dp[1][i-2])
        dp[1][i] = A[1][i] + max(dp[0][i-1],dp[0][i-2])

    print(max(dp[0][N-1],dp[1][N-1]))

