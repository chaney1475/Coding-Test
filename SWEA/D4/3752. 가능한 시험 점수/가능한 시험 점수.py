T = int(input())


for t in range(1, T + 1):
    N = int(input())
    A = list(map(int, input().split()))
    total = sum(A)

    dp = [[0] * (total + 1) for _ in range(N)]

    dp[0][0] = 1
    dp[0][A[0]] = 1

    for i in range(1,N):
        for j in range(total+1):
            score = A[i]
            if score > j:
                dp[i][j] = dp[i-1][j]
            else:
                if dp[i-1][j - score] or dp[i-1][j]:
                    dp[i][j] = 1

    print(f'#{t} {sum(dp[N-1])}')