import sys
from collections import deque

input = sys.stdin.readline

A, B, C = map(int, input().split())

tomato = []

visited = [[[False] * A for _ in range(B)] for _ in range(C)]

start = []
for i in range(C):
    t = []
    for j in range(B):
        temp = list(map(int, input().split()))
        for l in range(A):
            if temp[l] == 1:
                start.append([i, j, l])
        t.append(temp)

    tomato.append(t)

path = [[0, 0, 1], [0, 0, -1], [1, 0, 0], [-1, 0, 0], [0, 1, 0], [0, -1, 0]]

def bfs(start):
    q = deque()
    for i, j, l in start:
        q.append([i, j, l, 0])
        visited[i][j][l] = True
        tomato[i][j][l] = 0

    while q:
        x, y, z, days = q.popleft()
        for p1, p2, p3 in path:
            a = p1 + x
            b = p2 + y
            c = p3 + z
            if 0 <= a < C and 0 <= b < B and 0 <= c < A and not visited[a][b][c] and tomato[a][b][c] == 0:
                visited[a][b][c] = True
                tomato[a][b][c] = days + 1
                q.append([a, b, c, days + 1])


bfs(start)

cant = True
answer = 0
for i in range(C):
    for j in range(B):
        for l in range(A):
            if tomato[i][j][l] == 0 and not visited[i][j][l]:
                cant = False
                break
            answer = max(answer, tomato[i][j][l])
if cant:
    print(answer)
else:
    print(-1)
