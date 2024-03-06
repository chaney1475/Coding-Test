import sys

input = sys.stdin.readline

N = int(input())

A = []

for _ in range(N):
    A.append(list(map(int, input().split())))


def check(start, n):
    white = False
    blue = False
    for i in range(start[0], start[0] + n):
        for j in range(start[1], start[1] + n):
            if A[i][j] == 0:
                white = True
            else:
                blue = True
    if white and blue:
        return 0
    elif white and not blue:
        return 1
    else:
        return 2


a = 0
b = 0

def dfs(start, N):
    global a,b
    c = check(start, N)
    if c == 2:
        b += 1
        return
    elif c == 1:
        a += 1
        return
    else:
        dfs(start, N // 2)
        dfs([start[0] + N // 2, start[1]], N // 2)
        dfs([start[0], start[1] + N // 2], N // 2)
        dfs([start[0] + N // 2, start[1] + N // 2], N // 2)


dfs([0, 0], N)
print(a)
print(b)
