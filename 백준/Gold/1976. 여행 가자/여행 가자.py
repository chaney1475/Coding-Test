import sys

sys.setrecursionlimit(10000)

input = sys.stdin.readline
N = int(input())

A = []

B = [x for x in range(N + 1)]

M = int(input())

for i in range(N):
    A.append(list(map(int, input().split())))

path = list(map(int, input().split()))


def REP(x):
    if B[x] == x:
        return x
    else:
        B[x] = REP(B[x])
        return B[x]


def UNION(a, b):
    x = REP(a)
    y = REP(b)
    if x != y:
        B[y] = x


for i in range(N):
    for j in range(N):
        if A[i][j] == 1:
            UNION(i, j)

num = REP(B[path[0] - 1])

answer = "YES"
for i in path:
    if num != REP(B[i - 1]):
        answer = "NO"
        break
print(answer)


