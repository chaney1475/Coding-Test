import sys
import heapq
input = sys.stdin.readline

N = int(input())
M = int(input())

A = [[] for _ in range(N+1)]
visited = [False] * (N+1)

for _ in range(M):
    a, b, c = map(int, input().split())
    A[a].append([b, c])


distance = [sys.maxsize] * (N+1)
start, end = map(int, input().split())

distance[start] = 0
hq = [(0, start)]

while hq:
    dist, now = heapq.heappop(hq)
    if distance[now] < dist:
        continue
    for next, w in A[now]:
        new_distance = dist + w
        if distance[next] > new_distance:
            distance[next] = new_distance
            heapq.heappush(hq, (new_distance, next))

print(distance[end])

