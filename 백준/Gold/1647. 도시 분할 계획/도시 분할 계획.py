import sys
import heapq

input = sys.stdin.readline

N,M = map(int,input().split())

node = []
rep = [i for i in range(N+1)]

for _ in range(M):
    a,b,c = map(int,  input().split())
    heapq.heappush(node,[c,a,b])


ans = 0
i = 0

def find(a):
    if not rep[a] == a:
        rep[a] = find(rep[a])
    return rep[a]

def union(a, b):
    A = find(a)
    B = find(b)
    if B < A:
        A,B = B,A
    rep[B] = A

while i < N-2:
    dist, a, b = heapq.heappop(node)
    if find(a) == find(b):
        continue
    ans += dist
    union(a,b)
    i += 1

print(ans)