import sys
input = sys.stdin.readline

N,M = map(int, input().split())


def dfs(index, answer):
    if len(answer) == M:
        print(*answer)
        return

    for i in range(index, N+1):
        if i == 0:
            continue
        dfs(i, answer + [i])


dfs(0,[])