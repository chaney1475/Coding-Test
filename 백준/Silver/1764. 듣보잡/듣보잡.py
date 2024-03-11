import sys
input = sys.stdin.readline

N, M = map(int, input().split())
d = set()
b = set()
for _ in range(N):
    d.add(input().rstrip())
for _ in range(M):
    b.add(input().rstrip())

inter = d.intersection(b)
d = sorted(inter)
print(len(inter))
for i in d:
    print(i)

