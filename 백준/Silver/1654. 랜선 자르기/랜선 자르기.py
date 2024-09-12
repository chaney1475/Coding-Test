import sys

n = list(map(int, sys.stdin.readline().split()))
lis = []

for _ in range(n[0]):
    lis.append(int(sys.stdin.readline()))

lis.sort()

low, high = 1, lis[-1]

result = 0

while low <= high:
    mid = (low + high) // 2

    cnt = 0
    for num in lis:
        cnt += num // mid

    if cnt >= n[1]:
        result = mid
        low = mid + 1
    else:
        high = mid - 1

print(result)
