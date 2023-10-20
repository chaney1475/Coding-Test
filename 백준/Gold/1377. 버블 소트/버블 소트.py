import sys
input = sys.stdin.readline

N = int(input())
A = []
for i in range(N):
    A.append((int(input().rstrip()), i))

sorted_A = sorted(A)

max = 0
for i in range(N):
    if max < sorted_A[i][1] - A[i][1]:
        max = sorted_A[i][1] - A[i][1]
print(max + 1)