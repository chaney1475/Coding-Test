import sys
from collections import deque

input = sys.stdin.readline
N, M = map(int, input().split())

A = [[] for _ in range(N + 1)]
D = [0 for _ in range(N + 1)]

for _ in range(M):
    a, b = map(int, input().split())
    A[a].append(b)
    D[b] += 1

q = deque()
answer = []
for i in range(1, N + 1):
    if D[i] == 0:
        q.append(i)

while (q):
    now = q.popleft()
    answer.append(now)
    for a in A[now]:
        D[a] -= 1
        if D[a] == 0:
            q.append(a)

print(*answer)
