import sys
input = sys.stdin.readline
N = int(input())
A = input().rstrip()
sum = 0
for i in A:
    sum += int(i)
print(sum)

