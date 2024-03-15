import sys
import heapq
input = sys.stdin.readline

N, M, X = map(int, input().split())
INF = sys.maxsize

A = [[] for _ in range(N+1)]
reverse_A = [[] for _ in range(N+1)]

d = [INF] * (N+1)
d2 = [INF] * (N+1)

for _ in range(M):
    a,b, w = map(int, input().split())
    A[a].append((b, w))
    reverse_A[b].append((a,w))


def dijkstra(g, distance, start):
    q = []
    heapq.heappush(q,(0, start))
    while q:
        dist, now = heapq.heappop(q)
        if dist > distance[now]: continue
        for j in g[now]:
            cost = j[1] + dist
            if cost < distance[j[0]]:
                distance[j[0]] = cost
                heapq.heappush(q, (cost, j[0]))


dijkstra(A, d, X)
dijkstra(reverse_A, d2, X)

d[0] = 0
d2[0] = 0

d = [d[i] + d2[i] for i in range(N+1)]
d[X] = 0
print(max(d))

