import sys
from collections import deque


input = sys.stdin.readline

N = int(input())

A = [[] for _ in range(N+1)]
M = int(input())

visited = [0] * (N+1)


def bfs(start):
    q = deque()
    q.append(start)
    visited[start] = 1
    while q:
        now = q.popleft()
        for node in A[now]:
            if not visited[node]:
                visited[node] = 1
                q.append(node)


for _ in range(M):
    a,b = map(int, input().split())
    A[a].append(b)
    A[b].append(a)


bfs(1)
print(sum(visited)-1)