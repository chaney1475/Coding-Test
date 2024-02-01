import sys
input = sys.stdin.readline

#도시 - 노드
N = int(input())
#버스 - 간선
M = int(input())
INF = sys.maxsize
A = [[INF] * (N+1) for i in range(N+1)]


for i in range(N+1):
    for j in range(N+1):
        if i == j:
            A[i][j] = 0

for _ in range(M):
    a, b, w = map(int, input().split())
    if A[a][b] > w:
        A[a][b] = w


for n in range(1,N+1):
    for i in range(1,N+1):
        for j in range(1,N+1):
            if A[i][n] + A[n][j] < A[i][j]:
                A[i][j] = A[i][n] + A[n][j]


for i in range(1, N+1):
    for j in range(1, N+1):
        if A[i][j] == INF:
            A[i][j] = 0
        print(A[i][j], end=" ")
    print()
