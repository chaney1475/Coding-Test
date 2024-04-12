import sys
input = sys.stdin.readline

N = int(input())
A = []
for _ in range(N):
    n = int(input())
    if n == 0:
        A.pop()
    else:
        A.append(n)

print(sum(A))