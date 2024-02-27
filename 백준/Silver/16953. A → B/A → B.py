import sys

input = sys.stdin.readline

N, M = map(int, input().split())

answer = sys.maxsize

def dfs(cnt, n):
    global answer
    if n == M:
        if cnt < answer:
            answer = cnt
        return
    if n > M :
        return
    dfs(cnt+1, n * 2)
    dfs(cnt+1, n*10 +1)

dfs(0,N)
if answer != sys.maxsize:
    print(answer+1)
else:
    print(-1)
