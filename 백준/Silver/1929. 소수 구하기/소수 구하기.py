import sys
import math
input = sys.stdin.readline

N, M = map(int, input().split())

A = [0] *(M + 1)


for i in range(2, M+1):
    A[i] = i

for i in range(2, int(math.sqrt(M)) + 1):
    if A[i] == 0:
        continue
    for j in range(i+i, M+1, i):
        A[j] = 0

for i in range(N,M+1):
    if A[i] != 0:
        print(A[i], end=" ")

