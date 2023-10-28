import sys
input = sys.stdin.readline

count = [0] * 10001

N = int(input())
for i in range(N):
    count[int(input())] += 1

for i in range(10001):
    while count[i] != 0:
        print(i)
        count[i] -= 1

