import sys
from collections import deque

input = sys.stdin.readline

N, M = map(int, input().split())
A = []
path = [(0, 1), (0, -1), (1, 0), (-1, 0)]

D = [[sys.maxsize] * 1000 for _ in range(1000)]

s_x = -1
s_y = -1
for i in range(N):
    a = list(map(int, input().split()))
    if s_x == -1:
        for m in range(M):
            if a[m] == 2:
                s_x = i
                s_y = m
    A.append(a)

D[s_x][s_y] = 0


def bfs(x, y):
    q = deque()
    q.append((x, y, 0))
    while q:
        a, b, w = q.popleft()
        for p1, p2 in path:
            if 0 <= a + p1 < N and 0 <= b + p2 < M:
                if A[a + p1][b + p2] == 1:
                    if D[a + p1][b + p2] > w + 1:
                        D[a + p1][b + p2] = w + 1
                        q.append((a + p1, b + p2, w + 1))


bfs(s_x, s_y)

for i in range(N):
    for j in range(M):
        if A[i][j] == 0:
            print(A[i][j], end=" ")
        else:
            if D[i][j] == sys.maxsize:
                D[i][j] = -1
            print(D[i][j], end=" ")
    print()
