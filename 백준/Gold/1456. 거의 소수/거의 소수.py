#소수의 제곱
import sys
import math
input = sys.stdin.readline

M, N = map(int,input().split())

k = int(math.sqrt(N))

A = [0] * (k+1)

for i in range(2, k + 1):
    A[i] = i

for i in range(2, int(math.sqrt(k)) + 1):
    if A[i] == 0:
        continue
    for j in range(i+i, k+1, i):
        A[j] = 0


# k까지 0이 아닌 값들만 소수를 구함

cnt = 0
for i in range(2, k + 1):
    if A[i] != 0:
        n = A[i]
        total = n * n
        while total < M:
            total *= n
        while total <= N:
            cnt += 1
            total *= n
print(cnt)