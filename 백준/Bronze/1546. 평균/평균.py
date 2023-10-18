import sys
input = sys.stdin.readline

N = int(input())
numbers = list(map(int, input().split()))
sum = 0
for n in numbers:
    sum += n

big = max(numbers)
print(sum / N / big * 100)
