t = int(input())


def dfs(n, d):
    global max
    for i in A[n]:
        if not visited[i]:
            visited[i] = True
            dfs(i, d + 1)
            visited[i] = False
    if d > max:
        max = d


for test in range(1, t + 1):
    max = 0
    N, M = map(int, input().split())  # 노드수 간선수
    A = [[] for _ in range(N + 1 + 1)]
    visited = [False] * (N + 1)

    for m in range(M):
        u, v = map(int, input().split())
        A[u].append(v)
        A[v].append(u)

    if N == 1 or M == 0:
        max = 1
    else:
        for i in range(1, N+1):
            dfs(i, 0)

    print(f"#{test} {max}")
