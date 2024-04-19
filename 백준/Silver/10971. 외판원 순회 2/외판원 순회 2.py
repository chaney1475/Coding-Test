import sys

input = sys.stdin.readline

N = int(input())
A = []
for _ in range(N):
    A.append(list(map(int,input().split())))

answer = sys.maxsize

def dfs(first, now, cnt, temp):
    global answer
    if cnt == N :
        if A[now][first] != 0:
            answer = min(answer, temp + A[now][first])

    for i in range(N):
        if now == i:
            continue
        if not visited[i] and A[now][i] != 0:
            visited[i] = True
            dfs(first, i, cnt + 1, temp + A[now][i])
            visited[i] = False

for i in range(N):
    visited = [False] * (N)
    visited[i] = True
    dfs(i,i,1,0)
    visited[i] = False

print(answer)