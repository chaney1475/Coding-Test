import sys
input = sys.stdin.readline
n = int(input())
s = int(input())
nums = list(map(int, input().split()))
nums.sort()
start, end = 0, n-1
count = 0

while start < end:
    result = nums[start] + nums[end]
    if result == s:
        count += 1
        start += 1
        end -= 1
    elif result > s:
        end -= 1
    else:
        start += 1

print(count)




