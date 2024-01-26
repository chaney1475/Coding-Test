import sys

input = sys.stdin.readline
A = {}
B = []
N, M = map(int, input().split())

for _ in range(N):
    A[input().rstrip()] = 1

cnt = 0
for _ in range(M):
    a = input().rstrip()
    if A.get(a, 0):
        cnt += 1


print(cnt)