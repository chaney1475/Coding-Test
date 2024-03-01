import sys
from collections import deque
input = sys.stdin.readline

tomato = []
visited = [[False] * 1000 for _ in range(1000)]

raw = []
s = []
M, N = map(int, input().split())

for i in range (N):
    t = list(map(int, input().split()))
    for j in range(M):
        if t[j] == -1:
            visited[i][j] = True
        elif t[j] == 1:
            s.append((i,j))

    tomato.append(t)


path = [(0,-1),(0,1),(1,0),(-1,0)]


def bfs(s):
    q = deque()
    for a,b in s:
        q.append([a,b,0])
        visited[a][b] = True
        tomato[a][b] = 0
    while q:
        x,y,days = q.popleft()
        for p1,p2 in path:
            if 0 <= x + p1 < N and 0 <= y+p2 < M and not visited[x+p1][y+p2]:
                visited[x + p1][y + p2] = True
                tomato[x+p1][y+p2] = days +1
                q.append([x+p1,y+p2,days+1])


def check():
    max_num = 0
    for i in range(N):
        max_num = max(max_num,max(tomato[i]))
        for j in range(M):
            if not visited[i][j]:
                return -1
    return max_num
bfs(s)

print(check())
