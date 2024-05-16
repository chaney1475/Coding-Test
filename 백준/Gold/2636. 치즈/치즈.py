import sys
from collections import deque
input = sys.stdin.readline

N, M = map(int, input().split())

cheese = []

for _ in range(N):
    cheese.append(list(map(int, input().split())))

time = 0 #녹기까지 걸리는 시간
left_cheese = [] #각 초에 남은 치즈 갯수
dx = [0,0,1,-1]
dy = [1,-1,0,0]


def check_cheese():
    cnts = 0
    for i in range(N):
        cnts += sum(cheese[i])
    left_cheese.append(cnts)
    return cnts


def melt():
    cnt = [[0] * M for _ in range(N)]
    visited = [[False] * M for _ in range(N)]
    q = deque()
    q.append([0,0])
    visited[0][0] = True
    while q:
        x, y = q.popleft()
        for i in range(4):
            nx = dx[i] + x
            ny = dy[i] + y
            if nx < 0 or nx >= N or ny < 0 or ny >= M:
                continue
            if visited[nx][ny]:
                continue
            if cheese[nx][ny] == 1:
                cnt[nx][ny] += 1
            elif not visited[nx][ny]:
                q.append([nx,ny])
            visited[nx][ny] = True

    for i in range(N):
        for j in range(M):
            if cnt[i][j] != 0:
                cheese[i][j] = 0


while True:
    if check_cheese() == 0:
        break
    melt()


if len(left_cheese) == 1:
    print(0)
    print(0)
else:
    print(len(left_cheese) - 1)
    print(left_cheese[-2])
