import sys
from collections import deque

input = sys.stdin.readline

N = int(input())
tree = [[] for _ in range(N + 1)]

for _ in range(N - 1):
    a, b = map(int, input().split())
    tree[b].append(a)
    tree[a].append(b)

dept = [0] * (N + 1)
visited = [False] * (N + 1)


def sqaure(n):
    k = 0
    amount = 1
    while amount < n:
        amount *= 2
        k += 1
    k -= 1
    return k


kmax = sqaure(N)

parent = [[0] * (N + 1) for _ in range(kmax + 1)]


def bfs(v):
    q = deque()
    q.append(v)
    while q:
        now = q.popleft()
        visited[now] = True
        for c in tree[now]:
            if not visited[c]:
                dept[c] = dept[now] + 1
                parent[0][c] = now
                q.append(c)


bfs(1)

# i가 깊이 j가 값
for i in range(1, kmax+1):
    for j in range(2, N + 1):
        # 깊이가 i값
        if 2 ** i > dept[j]:
            continue
        parent[i][j] = parent[i - 1][parent[i - 1][j]]


def executeLCA(a, b):
    #깊은 노드가 b가 되도록
    if dept[a] > dept[b]:
        a, b = b, a

    for k in range(kmax, -1, -1):
        if pow(2,k) <= dept[b] - dept[a]:
            if dept[a] <= dept[parent[k][b]]:
                b = parent[k][b]

    for k in range(kmax,-1,-1):
        if a == b:
            break
        if parent[k][a] != parent[k][b]:
            a = parent[k][a]
            b = parent[k][b]
    LCA = a
    if a!= b:
        LCA = parent[0][LCA]
    return LCA


M = int(input())


for _ in range(M):
    a, b = map(int, input().split())
    print(executeLCA(a, b))


