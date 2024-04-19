import sys
input = sys.stdin.readline

N, M = map(int, input().split())

d = dict()
for _ in range(N):
    a,b = input().split()
    d[a] = b

for _ in range(M):
    print(d[input().rstrip()])