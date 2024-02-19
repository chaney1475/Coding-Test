import sys

input = sys.stdin.readline

N, M = map(int, input().split())

visited = [False] * (N+1)

answer = [0] * (N)

def dfs(last,k):
    if k == M:
        for i in range(M):
            print(answer[i], end=" ")
        print()
        return
    for i in range(last+1, N+1):
        if not visited[i]:
            answer[k] = i
            visited[i] = True
            dfs(i,k+1)
            visited[i] = False

dfs(0,0)