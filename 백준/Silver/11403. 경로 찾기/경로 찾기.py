import sys
input = sys.stdin.readline

N = int(input())

A = []

for _ in range(N):
    A.append(list(map(int, input().split())))


for n in range(N):
    for i in range(N):
        for j in range(N):
            if A[i][n] and A[n][j]:
                A[i][j] = 1


for i in range(N):
    for j in range(N):
        print(A[i][j], end=" ")
    print()
