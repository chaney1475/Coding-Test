import sys

input = sys.stdin.readline

N = int(input())

A, B = map(int, input().split())

G = [[] for i in range(N + 1)]

visited = [False] * (N + 1)

for i in range(int(input())):
    # a가 부모 b가 자식
    a, b = map(int, input().split())
    G[a].append(b)
    G[b].append(a)


def dfs(x, cnt):
    visited[x] = True
    global answer

    if x == B:
        answer = cnt
        return

    for g in G[x]:
        if not visited[g]:
            dfs(g, cnt + 1)

answer = -1
dfs(A,0)

print(answer)