import sys
from collections import deque
input = sys.stdin.readline
N, M, K, X = map(int, input().split())

A = [[] for _ in range(N+1)]
d = [sys.maxsize] * (N+1)

d[X] = 0

for _ in range(M):
    a,b = map(int, input().split())
    A[a].append(b)


visited = [False] * (N+1)

def bfs(n):
    q = deque()
    q.append((n,0))
    visited[n] = True
    while q:
        now, cnt = q.popleft()
        for a in A[now]:
            if not visited[a]:
                visited[a] = True
                d[a] = cnt+1
                q.append([a, cnt+1])

bfs(X)

answer = []
for i in range(1, N+1):
    if d[i] == K:
        answer.append(i)

if len(answer) == 0:
    print(-1)
else:
    for a in answer:
        print(a)