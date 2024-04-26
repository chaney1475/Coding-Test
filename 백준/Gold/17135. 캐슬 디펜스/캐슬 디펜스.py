import sys
from collections import deque
from itertools import combinations

input = sys.stdin.readline

N, M, D = map(int, input().split())
A = []

for _ in range(N):
    A.append(list(map(int, input().split())))

ind = [i for i in range(M)]
position = list(combinations(ind, 3))

def check(temp):
    for i in range(N):
        for j in range(M):
            if temp[i][j] == 1:
                return True
    return False
answer = 0

dx = [0,-1,0]
dy = [-1,0,1]

def bfs(a, temp):
    visited = [[False]*M for _ in range(N)]
    q = deque()
    q.append([N-1,a,1])
    visited[N-1][a] = True
    while q:
        x,y,dist = q.popleft()
        if dist > D:
            continue
        if temp[x][y] == 1:
            return x, y
        for i in range(3):
            nx = dx[i] + x
            ny = dy[i] + y
            if nx < 0 or nx >= N or ny < 0 or ny >= M or visited[nx][ny]:
                continue
            visited[nx][ny] = True
            q.append([nx,ny,dist+1])

    return -1, -1

def make(p, temp):
    global answer
    cnt = 0
    # check를 해서 1이 있으면 턴 시작
    while check(temp):
        posit = set()
        for pi in p:
            px,py = bfs(pi, temp)
            if px != -1: # 맞힐 사람이 존재함
                posit.add((px,py))
        for p1, p2 in posit:
            if temp[p1][p2] == 1:
                cnt += 1
                temp[p1][p2] = 0
        for i in range(N - 1, 0, -1):
            temp[i] = temp[i - 1]
        temp[0] = [0] * M

    answer = max(answer, cnt)

for p in position:
    temp = [[n[i] for i in range(M)] for n in A]
    make(p, temp)

print(answer)
