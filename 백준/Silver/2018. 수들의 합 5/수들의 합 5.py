import sys
input = sys.stdin.readline
n = int(input())
end_i, count, sum = 1, 1, 1

for start in range(1, n):
    while sum < n:
        end_i += 1
        sum += end_i
    if sum == n:
        count += 1
    sum -= start

print(count)