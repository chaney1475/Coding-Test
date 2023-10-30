import sys
from collections import deque
sys.setrecursionlimit(10000)
input = sys.stdin.readline
# 노드 갯수, 에지 개수, 시작점
N, M, s = map(int, input().split())

A = [[] for _ in range(N + 1)]

for _ in range(M):
    u, v = map(int, input().split())
    A[u].append(v)
    A[v].append(u)

for i in range(N + 1):
    A[i].sort()

v_DFS = [False] * (N + 1)
v_BFS = [False] * (N + 1)

def DFS(v):
    print(v, end=" ")
    v_DFS[v] = True
    for i in A[v]:
        if not v_DFS[i]:
            DFS(i)


def BFS(v):
    queue = deque()
    queue.append(v)
    v_BFS[v] = True
    while queue:
        node = queue.popleft()
        print(node, end=" ")
        for i in A[node]:
            if not v_BFS[i]:
                queue.append(i)
                v_BFS[i] = True


DFS(s)
print()
BFS(s)
