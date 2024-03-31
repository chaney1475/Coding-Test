import sys
from collections import deque
input = sys.stdin.readline


N = int(input())
A = [[] for _ in range(N+1)]
INF = -1
for _ in range(N-1):
    a,b,c = map(int, input().split())
    A[a].append((b, c))
    A[b].append((a, c))


distance = [-1] * (N+1)

def bfs(start):
    q = deque()
    q.append((start,0))
    distance[start] = 0

    while q:
        now, dist = q.popleft()
        for a,d in A[now]:
            if distance[a] != INF:
                continue
            distance[a] = dist + d
            q.append((a,distance[a]))

    answer = start
    for i in range(1,N+1):
        if distance[i] != INF and distance[answer] < distance[i]:
            answer = i
    return answer


s = bfs(1)
distance = [INF] * (N+1)
print(distance[bfs(s)])
