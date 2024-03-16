import sys
input = sys.stdin.readline


d1 = [0] * 41
d2 = [0] * 41

d1[0] = 1
d2[1] = 1

for i in range(2,41):
    d1[i] = d1[i-1] + d1[i-2]
    d2[i] = d2[i-1] + d2[i-2]

for _ in range(int(input())):
    k = int(input())
    print(d1[k],d2[k])
