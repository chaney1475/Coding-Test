import sys
from collections import deque

input = sys.stdin.readline

N = int(input())
A = []

visited = [[False] * N for _ in range(N)]

for _ in range(N):
    A.append(list(input().rstrip()))

path = [(0, 1), (0, -1), (1, 0), (-1, 0)]

def check1(i, j, color):
    q = deque()
    q.append((i, j))
    visited[i][j] = True
    while q:
        x, y = q.popleft()
        for p1, p2 in path:
            if 0 <= x + p1 < N and 0 <= y + p2 < N and not visited[x + p1][y + p2] and A[x + p1][y + p2] == color:
                visited[x + p1][y + p2] = True
                q.append((x + p1, y + p2))


def check2(i, j, color):
    q = deque()
    q.append((i, j))
    visited[i][j] = True

    same = ['R', 'G']

    while q:
        x, y = q.popleft()
        for p1, p2 in path:
            if 0 <= x + p1 < N and 0 <= y + p2 < N and not visited[x + p1][y + p2]:
                if A[x + p1][y + p2] == color or (A[x + p1][y + p2] in same and color in same):
                    visited[x + p1][y + p2] = True
                    q.append((x + p1, y + p2))


cnt1 = 0
cnt2 = 0

for i in range(N):
    for j in range(N):
        if not visited[i][j]:
            cnt1 += 1
            check1(i, j, A[i][j])


visited = [[False] * N for _ in range(N)]

for i in range(N):
    for j in range(N):
        if not visited[i][j]:
            cnt2 += 1
            check2(i, j, A[i][j])

print(cnt1, cnt2)
