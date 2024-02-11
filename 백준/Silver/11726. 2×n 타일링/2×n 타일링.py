import sys

input = sys.stdin.readline

N = int(input())

A = [[0] * (i + 1) for i in range(N + 1)]
MOD = 10007
for i in range(1, N + 1):
    A[i][i] = 1
    A[i][1] = i
    A[i][0] = 1

for i in range(3, N+1):
    for j in range(2, i):
        A[i][j] = A[i-1][j-1] + A[i-1][j]% MOD

answer = 1
k = 0
for i in range(N - 1, 0, -1):
    k += 1
    if k > N // 2:
        break
    answer += A[i][k]

print(answer % MOD)