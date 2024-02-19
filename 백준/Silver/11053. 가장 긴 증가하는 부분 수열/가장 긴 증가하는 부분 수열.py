import sys

input = sys.stdin.readline

a = [0]

N = int(input())
A = list(map(int, input().split()))
D = [1] * (N + 1)

for i in range(N):
    for j in range(i, -1, -1):
        if A[j] < A[i]:
            D[i] = max(D[i], D[j] + 1)

print(max(D))