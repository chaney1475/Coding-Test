import sys
import heapq
input = sys.stdin.readline

#버스 수, 간선수

N = int(input())

M = int(input())
A = [[] for _ in range(N+1)]
INF = sys.maxsize
lists = [[] for _ in range(N + 1)]
distance = [INF] * (N+1)

for _ in range(M):
    a,b,c = map(int, input().split())
    A[a].append((b,c))

def bfs(start, end):

    distance[start] = 0
    q = []
    lists[start] = [start]
    heapq.heappush(q,[0, start, [start]])

    while q:
        dist, now, list = heapq.heappop(q)
        if distance[now] < dist:
            continue
        for n_node, n_dist in A[now]:
            if n_dist + dist < distance[n_node]:
                distance[n_node] = n_dist + dist
                lists[n_node] = list
                q.append((distance[n_node],n_node,list + [n_node]))



start,end = map(int, input().split())
bfs(start,end)
print(distance[end])
lists[end].append(end)
print(len(lists[end]))
print(*lists[end])