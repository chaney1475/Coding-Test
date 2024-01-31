import sys
input = sys.stdin.readline

N, M = map(int, input().split())
A = []
W = [sys.maxsize] * (N+1)

for _ in range(M):
    a, b, w = map(int,input().split())
    A.append([a,b,w])

#출발도시 가중치 0
W[1] = 0

for _ in range(N-1):
    for edge in A:
        start = edge[0]
        end = edge[1]
        w = edge[2]
        if W[start] == sys.maxsize:
            continue
        if W[start] + w < W[end]:
            W[end] = W[start] + w

cycle = False

for edge in A:
    start = edge[0]
    end = edge[1]
    w = edge[2]
    if W[start] == sys.maxsize:
        continue
    if W[start] + w < W[end]:
        cycle = True
        break

if cycle:
    print("-1")
else:
    for i in range(2, N+1):
        if W[i] != sys.maxsize:
            print(W[i])
        else:
            print("-1")