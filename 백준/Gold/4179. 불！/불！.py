import sys
from collections import deque

input = sys.stdin.readline

N, M = map(int, input().split())

visited = [[False] * 1000 for _ in range(1000)]
fire = [[False] * 1000 for _ in range(1000)]
A = []
J = [-1, -1]
F = []
path = [(0, 1), (0, -1), (1, 0), (-1, 0)]

for i in range(N):
    a = list(input().rstrip())
    for j in range(M):
        if a[j] == 'J':
            J = [i, j]
        elif a[j] == 'F':
            F.append((i,j))

    A.append(a)


min_time = N*M + 1

def bfs():
    q = deque()
    # 0이면 불, 1이면 지훈이 길
    for i,j in F:
        q.append([0, (i,j)])

    q.append([1, J, 1])
    global min_time
    while q:
        now = q.popleft()
        # 불인 경우
        if now[0] == 0:
            x = now[1][0]
            y = now[1][1]
            for p1, p2 in path:
                if 0 <= x + p1 < N and 0 <= y + p2 < M and A[x + p1][y + p2] == '.':
                    if not fire[x + p1][y + p2]:
                        fire[x + p1][y + p2] = True
                        q.append([0, (x + p1, y + p2)])
        else: #지훈이 인경우
            x = now[1][0]
            y = now[1][1]
            if x == N-1 or x == 0 or y == M-1 or y == 0:
                if min_time > now[2]:
                    min_time = now[2]
            for p1, p2 in path:
                if 0 <= x + p1 < N and 0 <= y + p2 < M and A[x + p1][y + p2] == '.':
                    if not fire[x + p1][y + p2] and not visited[x + p1][y + p2]:
                        visited[x + p1][y + p2] = True
                        q.append([1, (x + p1, y + p2), now[2] + 1])


bfs()

if min_time == N*M+1:
    print("IMPOSSIBLE")
else:
    print(min_time)
