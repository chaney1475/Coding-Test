import sys
input = sys.stdin.readline
n = int(input())
start_i, end_i, count, sum = 1, 1, 1, 1

while end_i != n:
    if sum == n:
        end_i += 1
        sum += end_i
        count += 1
    elif sum < n:
        end_i += 1
        sum += end_i
    else:
        sum -= start_i
        start_i += 1

print(count)