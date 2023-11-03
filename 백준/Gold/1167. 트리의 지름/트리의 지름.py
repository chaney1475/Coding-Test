import sys

input = sys.stdin.readline
from collections import deque

N = int(input())

A = [[] for _ in range(N + 1)]

A.append([])

visited = [False] * (N + 1)
distance = [0] * (N + 1)

for _ in range(N):
    s = list(map(int, input().split()))
    a = [(s[i], s[i + 1]) for i in range(1, len(s) - 1, 2)]
    A[s[0]] = a

for i in A:
    i.sort()

def BFS(v):
    my_quque = deque()
    my_quque.append(v)
    visited[v] = True
    while my_quque:
        node = my_quque.popleft()
        for i in A[node]:
            if not visited[i[0]]:
                my_quque.append(i[0])
                visited[i[0]] = True
                distance[i[0]] = distance[node] + i[1]

BFS(1)
max_num = max(distance)
index = distance.index(max_num)

visited = [False] * (N + 1)
distance = [0] * (N + 1)

BFS(index)
print(max(distance))