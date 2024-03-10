import sys
input = sys.stdin.readline

N = int(input())

l = []
for _ in range(N):
    l.append(int(input()))

d = [0] * (N)

l.sort()

for i in range(N-1, -1, -1):
    d[i] = (N-i) * l[i]

print(max(d))
