import sys
from collections import deque

input = sys.stdin.readline

#지역의 수, 수색범위, 길의 수
N, M, R = map(int, input().split())
INF = sys.maxsize
distance = [INF] *(N+1)
#아이템
item = [0] + list(map(int, input().split()))

A = [[] for _ in range(N+1)]

for i in range(R):
    a,b,c = map(int, input().split())
    A[a].append((b,c))
    A[b].append((a,c))

max_sum = 0

def bfs(start):
    global max_sum
    visited = [False] * (N+1)
    q = deque()
    q.append([start,M])
    visited[start] = True
    while q:
        now, D = q.popleft()
        for next, dist in A[now]:
            if dist > D:
                continue
            visited[next] = True
            q.append([next, D - dist])

    answer = 0
    for i in range(N+1):
        if visited[i]:
            answer += item[i]

    max_sum = max(max_sum, answer)

for i in range(1,N+1):
    bfs(i)

print(max_sum)
