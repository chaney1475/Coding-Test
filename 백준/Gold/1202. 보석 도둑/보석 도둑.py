import sys
import heapq
input = sys.stdin.readline

N, K = map(int, input().split())

jewelry = []
bag = []


visited = [False] * (N+1)

for _ in range(N):
    a,b = map(int, input().split())
    jewelry.append((a,b))

for _ in range(K):
    bag.append(int(input()))

bag.sort()
jewelry.sort()

j_heap = []

total_v = 0

j = 0
for i in range(K):
    while j < N and bag[i] >= jewelry[j][0]:
        heapq.heappush(j_heap, -jewelry[j][1])
        j += 1
    if j_heap:
        total_v -= heapq.heappop(j_heap)


print(total_v)