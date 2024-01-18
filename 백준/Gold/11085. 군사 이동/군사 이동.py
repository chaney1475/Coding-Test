import sys
import heapq

input = sys.stdin.readline

# 노드수 간선수
N, E = map(int, input().split())

# 경로의 처음과 끝
Q, W = map(int, input().split())

Uni = [x for x in range(N + 1)]

hq = []
def rep(a):
    if Uni[a] == a:
        return a;
    else:
        Uni[a] = rep(Uni[a])
        return Uni[a]

def make_path(a,b):
    #포함관계
    Uni[rep(a)] = rep(b)

for i in range(E):
    a, b, w = map(int, input().split())
    heapq.heappush(hq, (-w, a, b))

result = 0
while hq:
    cost, start, end = heapq.heappop(hq)
    cost = -cost

    make_path(start, end)

    if rep(Q) == rep(W):
        result = cost
        break

print(result)
