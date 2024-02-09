import sys
input = sys.stdin.readline
N = int(input())

A = []
D = [0] * (N+2)
D[N+1] = 0
A.append([])

for i in range(1,N+1):
    A.append(list(map(int,input().split())))

for i in range(N, 0, -1):
    D[i] = D[i+1]
    if i + A[i][0] - 1 <= N:
        D[i] = max(D[i],D[i+A[i][0]] + A[i][1])

print(D[1])
