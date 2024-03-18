import sys
input = sys.stdin.readline

d = [0] * 102

d[0] = 0
d[1] = 1
d[2] = 1
d[3] = 1
d[4] = 2

for i in range(5, 101):
    d[i] = d[i-1] + d[i-5]

T = int(input())

for _ in range(T):
    print(d[int(input())])