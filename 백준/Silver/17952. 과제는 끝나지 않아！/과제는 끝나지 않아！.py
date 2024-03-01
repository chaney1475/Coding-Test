import sys
input = sys.stdin.readline

S = int(input())

work = []
total = 0

for i in range(S):
    value = list(map(int, input().split()))
    if len(value) == 3:
        a, b, c = value
        work.append([b,c])
    if len(work) == 0:
        continue
    work[-1][1] -= 1
    if work[-1][1] == 0:
        total += work[-1][0]
        work.pop()

print(total)
