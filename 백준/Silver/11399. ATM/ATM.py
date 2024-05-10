import sys

input = sys.stdin.readline
N = int(input())
A = list(map(int,input().split()))
A.sort()

temp = 0
answer = 0
for a in A:
    temp += a
    answer += temp

print(answer)