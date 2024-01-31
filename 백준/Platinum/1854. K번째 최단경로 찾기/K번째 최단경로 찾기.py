import sys
import heapq

input = sys.stdin.readline

N, M, k = map(int, input().split())

A = [[] for _ in range(N+1)]
distance = [[] for _ in range(N+1)]

for _ in range(M):
    a, b, w = map(int, input().split())
    A[a].append([b, w])

# 시작은 1번
hq = [(0, 1)]
distance[1].append(0)

while hq:
    dist, node = heapq.heappop(hq)
    for next, w in A[node]:
        new_dist = dist + w
        if len(distance[next]) >= k:
            if new_dist < -distance[next][0]:
                heapq.heappop(distance[next])
                heapq.heappush(distance[next], -new_dist)
                heapq.heappush(hq, (new_dist, next))
        else:
            heapq.heappush(distance[next], -new_dist)
            heapq.heappush(hq, (new_dist, next))

for i in range(1, N+1):
    if len(distance[i]) < k:
        print("-1")
    else:
        print(sorted([-d for d in distance[i]])[k-1])
