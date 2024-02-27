#스타트와 링크
import sys
input = sys.stdin.readline

N = int(input())

A = []
sum_total = 0
for _ in range(N):
    a = list(map(int, input().split()))
    A.append(a)
    sum_total += sum(a)

visited = [False] * 20


min_total = 20000

def check():
    global min_total

    total1 = 0
    total2 = 0
    flag = False
    for i in range(N):
        for j in range(N):
            if i == j:
                continue
            if visited[i] and visited[j]:
                flag = True
                total1 += A[i][j]
            if not visited[i] and not visited[j]:
                total2 += A[i][j]
    if not flag:
        return
    if abs(total1-total2) < min_total:
        min_total = abs(total1 - total2)


def dfs(n, cnt):
    if cnt == N//2:
        check()
        return
    if n == N:
        return
    dfs(n+1,cnt)
    visited[n] = True
    dfs(n+1, cnt+1)
    visited[n] = False

dfs(0,0)


print(min_total)
