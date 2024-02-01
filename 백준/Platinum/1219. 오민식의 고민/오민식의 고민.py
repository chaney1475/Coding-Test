import sys

input = sys.stdin.readline
from collections import deque

# 도시수, 시작, 도착, 간선
N, S, E, M = map(int, input().split())

A = []
distance = [-sys.maxsize] * N

for _ in range(M):
    a, b, w = map(int, input().split())
    A.append([a, b, w])

country = list(map(int, input().split()))

distance[S] = country[S]

for _ in range(N - 1):
    for edge in A:
        start = edge[0]
        end = edge[1]
        money = country[end] - edge[2]  # 추가될 돈의 양 (음수일 수도 있음)
        if distance[start] != (-sys.maxsize) and distance[end] < distance[start] + money:
            distance[end] = distance[start] + money

not_arrive = False
if distance[E] == (-sys.maxsize):
    not_arrive = True

visited = [False] * N

for start, end, w in A:
    money = country[end] - w  # 추가될 돈의 양 (음수일 수도 있음)
    if distance[start] != (-sys.maxsize) and distance[end] < distance[start] + money:
        distance[end] = distance[start] + money  # 양의 루프를 도는 노드들중 하나
        visited[end] = True


def bfs(i):
    queue = deque()
    queue.append(i)
    while queue:
        now = queue.popleft()
        visited[now] = True
        for a in A:
            money = country[a[1]] - a[2]
            if a[0] == now and not visited[a[1]]:
                queue.append(a[1])


for i in range(N):
    if visited[i]:
        bfs(i)

if not_arrive:
    print("gg")
else:
    if visited[E]:
        print("Gee")
    else:
        print(distance[E])
