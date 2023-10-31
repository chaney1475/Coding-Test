import sys

input = sys.stdin.readline
from collections import deque

n, m = map(int, input().split())

A = []

visited = [[False] * m for _ in range(n)]

queue = deque()

for _ in range(n):
    row_input = input().rstrip()
    row = [int(k) for k in row_input]
    A.append(row)


def check(a, b, s):
    if n > a >= 0 and m > b >= 0 and A[a][b] == 1 and not visited[a][b]:
        queue.append((a, b))
        A[a][b] += s
        visited[a][b] = True


def BFS():
    queue.append((0, 0))
    visited[0][0] = True
    while queue:
        popleft = queue.popleft()
        a = popleft[0]
        b = popleft[1]
        if a == n - 1 and b == m - 1:
            return A[a][b]
        check(a - 1, b, A[a][b])
        check(a + 1, b, A[a][b])
        check(a, b - 1, A[a][b])
        check(a, b + 1, A[a][b])


print(BFS())
