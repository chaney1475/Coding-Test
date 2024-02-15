import sys
from collections import deque

input = sys.stdin.readline

N = int(input())

house = []
for _ in range(N):
    house.append(list(map(int, input().rstrip())))

path = [(0, 1), (0, -1), (1, 0), (-1, 0)]

answer = []

c = 0
def bfs(i, j):
    q = deque()
    q.append((i, j))
    t = 0
    while q:
        i, j = q.popleft()
        t += 1
        for a, b in path:
            if 0 <= a + i < N and 0 <= b + j < N:
                if house[a + i][b + j] == 1:
                    house[a + i][b + j] = 2
                    q.append((a + i, b + j))
    answer.append(t)


for i in range(N):
    for j in range(N):
        if house[i][j] == 1:
            house[i][j] = 2
            bfs(i, j)
            c += 1

answer.sort()

print(c)
for i in answer:
    print(i)
