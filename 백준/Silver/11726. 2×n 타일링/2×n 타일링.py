import sys

input = sys.stdin.readline

N = int(input())

A = [[0] * (i + 1) for i in range(N + 1)]
MOD = 10007
for i in range(1, N + 1):
    A[i][i] = 1
    A[i][1] = i
    A[i][0] = 1


def dp(a, b):
    if a == 0:
        return 0
    if A[a][b] == 0:
        A[a][b] = dp(a - 1, b - 1) + dp(a - 1, b) % MOD
    return A[a][b]


answer = 1
k = 0
for i in range(N - 1, 0, -1):
    k += 1
    if k > N // 2:
        break
    answer += dp(i, k)

print(answer % MOD)