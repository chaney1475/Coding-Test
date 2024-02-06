import sys
input = sys.stdin.readline



A = [[0] * (14+1) for _ in range(14+1)]

for i in range(14+1):
    A[0][i] = i

for i in range(1, 14+1):
    for j in range(1, 15):
        A[i][j] = A[i-1][j] + A[i][j-1]

#층수
T = int(input())
for t in range(0,T):
    K = int(input())
    N = int(input())
    print(A[K][N])

