import sys

input = sys.stdin.readline
from collections import deque
import heapq

N, M = map(int, input().split())

A = []

lands = 0
for _ in range(N):
    A.append(list(map(int, input().split())))
q = deque()

visited = [[False] * M for _ in range(N)]

path = [[0, 1], [0, -1], [1, 0], [-1, 0]]


def BFS(i, j):
    global lands
    lands += 1

    q.clear()

    q.append((i, j))
    visited[i][j] = True
    while q:
        first, second = q.popleft()
        A[first][second] = lands
        visited[first][second] = True
        for p0, p1 in path:
            if -1 < first + p0 < N and -1 < second + p1 < M:
                if not visited[first + p0][second + p1] and A[first + p0][second + p1] == 1:
                    q.append((first + p0, second + p1))


for i in range(N):
    for j in range(M):
        if A[i][j] == 1 and not visited[i][j]:
            BFS(i, j)


bridges = []

for i in range(N):
    # 시작노드
    b_node = 0
    # 다리 길이
    b_len = 0
    for j in range(M):
        # 섬일 때
        if A[i][j] != 0:
            # 시작 노드와 현재 노드가 같은 섬일 때
            if b_node == A[i][j]:
                b_len = 0
                continue
            # 다리 시작
            if b_node == 0:
                b_node = A[i][j]
            # 다리 끝
            else:
                if b_len > 1:
                    heapq.heappush(bridges, (b_len, b_node, A[i][j]))
                b_len = 0
                b_node = A[i][j]
        else:
            # 시작노드 값이 있으면
            if b_node:
                b_len += 1

for j in range(M):
    # 시작노드
    b_node = 0
    # 다리 길이
    b_len = 0
    for i in range(N):
        if A[i][j] != 0:
            # 시작 노드와 현재 노드가 같은 섬일 때
            if b_node == A[i][j]:
                b_len = 0
                continue
            # 다리 시작
            if b_node == 0:
                b_node = A[i][j]
                b_len = 0
            # 다리 끝
            else:
                if b_len > 1:
                    heapq.heappush(bridges, (b_len, b_node, A[i][j]))
                b_len = 0
                b_node = A[i][j]
        else:
            # 시작노드 값이 있으면
            if b_node:
                b_len += 1

uni = [i for i in range(lands + 1)]


def find(v):
    if uni[v] != v:
        uni[v] = find(uni[v])
    return uni[v]


def union(a, b):
    a = find(a)
    b = find(b)
    if a < b:
        uni[b] = a
    else:
        uni[a] = b


total_bridge = 0
nodes = 0
while bridges:
    w, a, b = heapq.heappop(bridges)
    if find(a) != find(b):
        union(a, b)
        total_bridge += w
        nodes += 1
        if nodes == lands -1:
            break


connected = True
represent = find(1)
for i in range(1, lands+1):
    if find(i) != represent:
        connected = False
        break

if connected:
    print(total_bridge)
else:
    print("-1")
