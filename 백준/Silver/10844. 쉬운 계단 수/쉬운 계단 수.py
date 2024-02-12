import sys
input = sys.stdin.readline

N = int(input())

D = [[0]*10 for _ in range(100+1)]

MOD = 1000000000

for i in range(1, 10):
    D[1][i] = 1

for i in range(2, 100+1):
    for j in range(10):
        if j == 0:
            D[i][j] = D[i-1][j+1]
        elif j == 9:
            D[i][j] = D[i-1][j-1]
        else:
            D[i][j] = D[i-1][j-1] + D[i-1][j+1]
        D[i][j] = D[i][j] % MOD


total = sum(D[N])
print(total % MOD)

