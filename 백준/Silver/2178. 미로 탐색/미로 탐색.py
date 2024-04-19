import sys
from collections import deque
input = sys.stdin.readline

N,M = map(int, input().split())

A = []
for _ in range(N):
    A.append(list(map(int, input().rstrip())))

visited = [[False] * M for _ in range(N)]
dx = [0,1,0,-1]
dy = [1,0,-1,0]

def bfs():
    q = deque()
    q.append([0,0,1])

    while q:
        x,y,d = q.popleft()
        if x == N-1 and y == M-1:
            return d
        for i in range(4):
            nx = dx[i] + x
            ny = dy[i] + y
            if 0 <= nx < N and 0 <= ny < M and A[nx][ny] == 1 and not visited[nx][ny]:
                visited[nx][ny] = True
                q.append([nx,ny,d+1])

print(bfs())
