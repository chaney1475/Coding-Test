T = int((input()))
from collections import deque

dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]


def bfs():
    tmp = 0
    global answer
    q = deque()
    q.append([0,0,0])
    while q:
        x, y, tmp = q.popleft()
        if x == N - 1 and y == N - 1:
            if answer > tmp:
                answer = tmp
            continue
        if ((N - x) + (N - y) - 3) * min_num + tmp >= answer:
            continue
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx < 0 or nx >= N or ny < 0 or ny >= N:
                continue
            if cost[nx][ny] > tmp + ground[nx][ny]:
                cost[nx][ny] = tmp + ground[nx][ny]
                q.append([nx, ny, tmp + ground[nx][ny]])


for t in range(1, 1 + T):
    N = int(input())

    ground = []
    min_num = N * N

    for _ in range(N):
        l = input().rstrip()
        l = [int(r) for r in l]
        min_num = min(min_num, min(l))
        ground.append(l)

    cost = [[N * N * 9] * N for _ in range(N)]
    answer = N * N * 9
    cost[0][0] = 0

    bfs()

    print(f"#{t} {answer}")
