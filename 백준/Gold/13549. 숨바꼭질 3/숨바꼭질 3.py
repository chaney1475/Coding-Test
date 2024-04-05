import sys
from collections import deque

input = sys.stdin.readline

#수빈이 위치, 동생의 위치
N,M = map(int, input().split())

visited = [sys.maxsize] * 100001

def bfs():
    q = deque()
    q.append((N,0))
    visited[N] = 0
    while q:
        loca, cnt = q.popleft()
        if loca * 2 <= 100000:
            if visited[loca * 2] > cnt:
                visited[loca * 2] = cnt
                q.append((loca * 2, cnt))
        if loca + 1 <= 100000:
            if visited[loca + 1] > cnt + 1:
                visited[loca + 1] = cnt + 1
                q.append((loca+1, cnt + 1))
        if loca - 1 >= 0:
            if visited[loca - 1] > cnt + 1:
                visited[loca - 1] = cnt + 1
                q.append((loca - 1, cnt + 1))

bfs()
print(visited[M])