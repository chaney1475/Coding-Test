import sys
from collections import deque
input = sys.stdin.readline

N, M = map(int, input().split())

A = []
visited = [[[0] * 2 for _ in range(M)] for _ in range(N)]
visited[0][0][0] = 1

for i in range(N):
    A.append(list(map(int, input().rstrip())))

dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]

def bfs():
    q = deque()
    q.append((0,0,0))

    while q:
        x, y, crash = q.popleft()
        if x == N - 1 and y == M - 1:
            return visited[x][y][crash]

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < N and 0 <= ny < M:
                if A[nx][ny] == 1 and crash == 0:
                    visited[nx][ny][1] = visited[x][y][0] + 1
                    q.append((nx,ny,1))
                elif A[nx][ny] == 0 and visited[nx][ny][crash] == 0:
                    visited[nx][ny][crash] = visited[x][y][crash] + 1
                    q.append((nx,ny,crash))
    return -1

print(bfs())