import sys
input = sys.stdin.readline

N, K = map(int, input().split())
MOD = 1000000000
D = [[1] * (201) for _ in range(201)]


for i in range(1,201):
    for j in range(2, 201):
        D[i][j] = (D[i-1][j] + D[i][j-1]) % MOD

print(D[N][K])