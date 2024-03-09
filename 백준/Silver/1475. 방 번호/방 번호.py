import sys
input = sys.stdin.readline


d = [0] * 10

num = input().rstrip()


for i in range(len(num)):
    d[int(num[i])] += 1

mid = (d[9] + d[6]) / 2
if int(mid) == mid:
    d[9] = int(mid)
    d[6] = int(mid)
else:
    d[9] = int(mid) + 1
    d[6] = int(mid)

print(max(d))
