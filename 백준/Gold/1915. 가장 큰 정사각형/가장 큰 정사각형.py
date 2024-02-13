import sys
input = sys.stdin.readline

n, m = map(int, input().split())

A = [[0] * 1000 for _ in range(1001)]

max = 0
for i in range(n):
    nums = list(map(int, input().rstrip()))
    for j in range(m):
        A[i][j] = nums[j]
        if A[i][j] == 1 and j > 0 and i > 0:
            A[i][j] = min(A[i-1][j-1], A[i-1][j], A[i][j-1]) + A[i][j]
        if max < A[i][j]:
            max = A[i][j]

print(max * max)
