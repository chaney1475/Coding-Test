import sys
input = sys.stdin.readline

N = int(input())
A = [[0] * 101 for _ in range(101)]


for n in range(N):
    a, b = map(int, input().split())
    for i in range(a+1,a+11):
        for j in range(b+1, b+11):
            A[i][j] = 1

total = 0
for i in range(1,101):
    total += sum(A[i])

print(total)