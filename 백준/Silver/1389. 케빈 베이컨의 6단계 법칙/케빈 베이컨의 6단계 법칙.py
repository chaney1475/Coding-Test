import sys
input = sys.stdin.readline

N, M = map(int, input().split())

INF = sys.maxsize
A = [[INF] * (N+1) for _ in range(N+1)]

for _ in range(M):
    a, b = map(int, input().split())
    A[a][b] = 1
    A[b][a] = 1

for i in range(N+1):
    A[i][i] = 0
for n in range(1,N+1):
    for i in range(N + 1):
        for j in range(N + 1):
            A[i][j] = min(A[i][n]+A[n][j], A[i][j])

distance = [0] * (N+1)

for i in range(1, N+1):
    for j in range(1,N+1):
        distance[i] += A[i][j]

answer = INF
for i in range(1, N+1):
    if distance[i] < answer:
        answer = distance[i]

print(distance.index(answer))