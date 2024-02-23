import sys

input = sys.stdin.readline

N, M = map(int, input().split())

A = []

max_val = 0

for i in range(N):
    A.append(list(map(int, input().split())))
    max_val = max(max(A[i]), max_val)

path = [(0, 1), (0, -1), (1, 0), (-1, 0)]
visited = [[False] * M for _ in range(N)]

bigest = 0


def dfs(a, b, cnt, total):
    global bigest
    if cnt == 4:
        if total > bigest:
            bigest = total
        return
    if (4 - cnt) * max_val + total <= bigest:
        return
    for p1, p2 in path:
        if 0 <= p1 + a < N and 0 <= p2 + b < M:
            if not visited[a + p1][b + p2]:
                visited[p1 + a][b + p2] = True
                dfs(p1 + a, b + p2, cnt + 1, total + A[a + p1][b + p2])
                if cnt == 2:
                    dfs(a, b, cnt + 1, total + A[a + p1][b + p2])
                visited[p1 + a][b + p2] = False

for i in range(N):
    for j in range(M):
        visited[i][j] = True
        dfs(i, j, 1, A[i][j])
        visited[i][j] = False

print(bigest)
