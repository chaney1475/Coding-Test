import sys
from collections import deque
input = sys.stdin.readline

N, M = map(int, input().split())

A = []
cost = []
for _ in range(N):
    A.append(list(input().rstrip()))
for _ in range(N):
    cost.append(list(map(int, input().split())))

visited = [[False] * M for _ in range(N)]

answer = 0

def check_rotate(x,y):
    global answer
    q = [[x,y]]
    v = [cost[x][y]]
    while -1 < x < N and -1 < y < M:
        if visited[x][y]:
            if [x,y] in q:
                index = q.index([x, y])
                answer += min(v[index:])
            return
        visited[x][y] = True
        q.append([x,y])
        v.append(cost[x][y])
        now = A[x][y]
        if now == "L":
            y -= 1
        elif now == "R":
            y += 1
        elif now == "U":
            x -= 1
        else:
            x += 1

for i in range(N):
    for j in range(M):
        if not visited[i][j]:
            check_rotate(i,j)

print(answer)
