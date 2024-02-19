import sys

input = sys.stdin.readline

N, M = map(int, input().split())

visited = [False] * N


# 0일때 1인걸로 visited 확인

def dfs(answer):
    if len(answer) == M:
        print(" ".join(answer))
        return
    for i in range(1, N + 1):
        if not visited[i - 1]:
            visited[i - 1] = True
            dfs(answer + str(i))
            visited[i - 1] = False


dfs("")
