import sys
from itertools import combinations as comb
from collections import deque

input = sys.stdin.readline

zero = []
virus = []

N,M = map(int, input().split())
A = []

for i in range(N):
    a = list(map(int, input().split()))
    for j in range(M):
        if a[j] == 0:
            zero.append([i,j])
        elif a[j] == 2:
            virus.append([i,j])
    A.append(a)

temp = list(comb(zero,3))

dx = [0,0,1,-1]
dy = [1,-1,0,0]

answer = 0

def check():
    copy = [[a for a in A[n]] for n in range(N)]
    global answer
    q = deque()
    visited = [[False] * M for _ in range(N)]
    for v1,v2 in virus:
        q.append([v1,v2])
        visited[v1][v2] = True
    while q:
        x,y = q.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx < 0 or nx >= N or ny < 0 or ny >= M:
                continue
            if visited[nx][ny]:
                continue
            if copy[nx][ny] == 0:
                copy[nx][ny] = 2
                visited[nx][ny] = True
                q.append([nx,ny])

    cnt = 0
    for n in range(N):
        for m in range(M):
            if copy[n][m] == 0:
                cnt += 1

    answer = max(answer,cnt)


visited = [[False] * M for _ in range(N)]
for ts in temp:
    for a, b in ts:
        A[a][b] = 1
    check()
    for a, b in ts:
        A[a][b] = 0

print(answer)