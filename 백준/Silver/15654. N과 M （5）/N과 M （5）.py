import sys

input = sys.stdin.readline

N, M = map(int, input().split())

A = list(map(int, input().split()))
visited = [False] * N
A.sort()


def dfs(cnt, l):
    if cnt == 0:
        print(*l)
    for j in range(0, len(A)):
        if not visited[j]:
            visited[j] = True
            dfs(cnt-1, l + [A[j]])
            visited[j] = False

dfs(M,[])