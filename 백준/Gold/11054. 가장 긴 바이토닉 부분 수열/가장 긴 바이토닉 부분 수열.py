import sys
input = sys.stdin.readline
N = int(input())
A = list(map(int, input().split()))
up = [1] * N
down = [0] * N

for i in range(N):
    for j in range(0,i):
        if A[j] < A[i]:
            if up[i] <= up[j]:
                up[i] = up[j] + 1

for i in range(N-1,-1,-1):
    for j in range(N-1,i,-1):
        if A[j] < A[i]:
            if down[i] <= down[j]:
                down[i] = down[j] + 1

answer = max(up[i]+down[i] for i in range(N))
print(answer)


