import sys
input = sys.stdin.readline

N, Total = map(int, input().split())
A = []

for i in range(1, N+1):
    a = int(input().rstrip())
    A.append(a)
answer = 0 # ~ n-1까지
for i in range(N-1, -1, -1):
    answer += Total // A[i]
    Total = Total % A[i]
    if Total == 0:
        break

print(answer)