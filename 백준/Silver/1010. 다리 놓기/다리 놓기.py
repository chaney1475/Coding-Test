import sys
input = sys.stdin.readline

A = [[0] * (30+1) for _ in range(31)]

for i in range(31):
    A[i][0] = 1
    A[i][i] = 1
    A[i][1] = i

for i in range(3,31):
    for j in range(2, i+1):
        A[i][j] = A[i-1][j] + A[i-1][j-1]


for t in range(int(input())):
    N, K = map(int, input().split())
    print(A[K][N])
