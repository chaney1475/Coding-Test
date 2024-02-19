import sys

input = sys.stdin.readline

N, M = map(int, input().split())

def dfs(answer):
    if len(answer) == M:
        print(" ".join(answer))
        return
    for i in range(1, N + 1):
        dfs(answer + str(i))


dfs("")
