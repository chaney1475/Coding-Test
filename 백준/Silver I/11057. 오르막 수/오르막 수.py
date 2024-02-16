import sys
input = sys.stdin.readline

N = int(input())
MAX = 1000
dp = [[0]*10 for _ in range(MAX+1)]
MOD = 10007

for i in range(10):
    dp[1][i] = 1

#몇번째 줄인지 i
for i in range(2,N+1):
    #업데이트할 값
    for j in range(10):
        for k in range(j+1):
            dp[i][j] += dp[i-1][k]
            dp[i][j] %= MOD

total = 0
for i in range(10):
    total += dp[N][i] % MOD

print(total % MOD)