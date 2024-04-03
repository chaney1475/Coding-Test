import sys
from collections import deque

input = sys.stdin.readline

N, M = map(int, input().split())
visited = [[False] * M for _ in range(N)]
A = [[0] * M for _ in range(N)]
cheese = []


for _ in range(N):
    cheese.append(list(map(int, input().split())))

dx = [0, 0, -1, 1]
dy = [1, -1, 0, 0]

def bfs(x,y):
    A
    q = deque()
    visited[x][y] = True
    q.append((x,y))
    while q:
        a,b = q.popleft()
        for i in range(4):
            na = dx[i] + a
            nb = dy[i] + b
            if 0 <= na < N and 0 <= nb < M and not visited[na][nb]:
                if cheese[na][nb] == 1:
                    A[na][nb] += 1
                else:
                    visited[na][nb] = True
                    q.append((na,nb))
    flag = True
    for i in range(N):
        for j in range(M):
            if A[i][j] >= 2:
                cheese[i][j] = 0
                flag = False
    return flag


cnt = 0
while not bfs(0,0):
    cnt += 1
    visited = [[False] * M for _ in range(N)]
    A = [[0] * M for _ in range(N)]

print(cnt)