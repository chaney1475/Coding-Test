import sys
input = sys.stdin.readline

N,M = map(int, input().split())
A = []
for _ in range(N):
    A.append(int(input()))

A.sort()

start = 1
end = A[-1] - A[0]

result = 0

while start <= end:
    mid = (start + end) // 2
    current = A[0]
    count = 1

    for i in range(1, len(A)):
        if A[i] - current >= mid:
            count += 1
            current = A[i]
    if count >= M:
        start = mid +1
        result = mid
    else:
        end = mid - 1

print(result)
