import sys
input = sys.stdin.readline

A = dict()

N = int(input())

L = map(int,input().split())
for l in L:
    A[l] = 1

answer = []
M = int(input())

C = map(int,input().split())

for c in C:
    if A.get(c, 0):
        answer.append(1)
    else:
        answer.append(0)

print(*answer)
