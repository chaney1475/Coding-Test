import sys
from collections import deque

input = sys.stdin.readline

N, M, V = map(int, input().split())

A = [[] for _ in range(N+1)]

for _ in range(M):
    a,b = map(int, input().split())
    A[a].append(b)
    A[b].append(a)

for i in range(1,N+1):
    A[i].sort()

def dfs(v):
    for node in A[v]:
        if not visited[node]:
            visited[node] = True
            dfs_answer.append(node)
            dfs(node)

def bfs(v):
    q = deque()
    q.append(v)
    while q:
        node = q.popleft()
        for n in A[node]:
            if not visited[n]:
                visited[n] = True
                bfs_answer.append(n)
                q.append(n)


visited = [False] * (N+1)
dfs_answer = [V]
visited[V] = True
dfs(V)
print(*dfs_answer)

visited = [False] * (N+1)
bfs_answer = [V]
visited[V] = True
bfs(V)
print(*bfs_answer)