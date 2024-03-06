import sys
from collections import deque
input = sys.stdin.readline

M, N, K = map(int, input().split())

A = [[0] * M for _ in range(N)]
visited = [[False] * M for _ in range(N)]

for _ in range(K):
    a1,b1, a2,b2 = map(int, input().split())
    for i in range(a1, a2):
        for j in range(b1,b2):
            A[i][j] = 1

area = []


path = [(1,0),(-1,0),(0,1),(0,-1)]

def bfs(a,b):
    visited[a][b] = True
    q = deque()
    q.append((a,b))
    cnt = 1
    while q:
        a,b = q.popleft()
        for p1, p2 in path:
            if 0 <= a+p1 < N and 0 <= b+p2 < M and A[a+p1][b+p2] == 0 and not visited[a+p1][b+p2]:
                visited[a + p1][b + p2] = True
                cnt += 1
                q.append((a+p1, b+p2))
    area.append(cnt)

for i in range(N):
    for j in range(M):
        if not visited[i][j] and A[i][j] == 0:
            bfs(i,j)

print(len(area))
area.sort()
for a in area:
    print(a, end=" ")