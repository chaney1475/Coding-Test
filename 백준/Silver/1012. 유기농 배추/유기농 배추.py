import sys
from collections import deque
input = sys.stdin.readline

T = int(input())

path = [(1,0),(-1,0),(0,1),(0,-1)]


def bfs(a,b):
    q = deque()
    q.append((a,b))
    g[a][b] = cnt
    while q:
        x, y = q.popleft()
        for p1, p2 in path:
            if 0 <= x + p1 < N and 0 <= y + p2 < M:
                if g[x + p1][y + p2] == -1:
                    g[x + p1][y + p2] = cnt
                    q.append((x + p1, y + p2))


for t in range(T):
    g = [[0] * (50 + 1) for _ in range(50 + 1)]
    M, N, K = map(int, input().split())

    for i in range(K):
        b, a = map(int, input().split())
        g[a][b] = -1

    cnt = 0
    for i in range(N):
        for j in range(M):
            if g[i][j] == -1:
                cnt += 1
                bfs(i, j)

    print(cnt)