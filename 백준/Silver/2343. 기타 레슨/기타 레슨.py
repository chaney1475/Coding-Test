import sys

input = sys.stdin.readline

N, M = map(int, input().split())

A = list(map(int, input().split()))

answer = 0
left, right = max(A), sum(A)

while left <= right:
    mid = (left + right) // 2

    count, sum = 0, 0
    for i in range(N):
        if sum + A[i] > mid:
            count += 1
            sum = 0
        sum += A[i]
    if sum:
        count += 1
    if count > M:
        left = mid + 1
    else:
        right = mid - 1
        answer = mid

print(answer)