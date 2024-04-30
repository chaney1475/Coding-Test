import sys
from collections import deque
from itertools import combinations

input = sys.stdin.readline

N = int(input())

REP = [i for i in range(N + 1)]

cost = [0]
cost += list(map(int, input().split()))

node = [[] for _ in range(N + 1)]

for i in range(1, N + 1):
    a = list(map(int, input().split()))
    for n in a[1:]:
        node[i].append(n)

def bfs(same): #같은 선거구인지 확인
    start = same[0]
    q = deque([start])
    visited = set([start])
    sum = 0
    while q:
        v = q.popleft()
        sum += cost[v]
        for u in node[v]:
            if u not in visited and u in same:
                q.append(u)
                visited.add(u)

    return sum, len(visited)


answer = sys.maxsize


indexs = [i for i in range(1,N+1)]
for i in range(1,N//2+1):
    L = list(combinations(indexs,i))
    for l in L:
        sum1, v1 = bfs(l)
        sum2, v2 = bfs([i for i in range(1,N+1) if i not in l])
        if v1 + v2 == N:
            answer = min(answer,abs(sum1-sum2))

if answer != sys.maxsize:
    print(answer)
else:
    print(-1)