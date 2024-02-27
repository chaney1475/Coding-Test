import sys
input = sys.stdin.readline

N = int(input())

A = list(map(int, input().split()))

l = [i for i in range(1000+1)]
l[1] = 0

for i in range(2,int(1000**0.5) +1):
    if l[i] == 0:
        continue
    k = i + i
    while k < 1001:
        l[k] = 0
        k += i

cnt = 0
for a in A:
    if l[a] != 0:
        cnt += 1

print(cnt)
