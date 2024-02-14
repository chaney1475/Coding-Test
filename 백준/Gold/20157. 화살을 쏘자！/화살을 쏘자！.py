import sys
from math import gcd
from collections import defaultdict
input = sys.stdin.readline

N = int(input())

x = 0
p_x = 0

y = 0
p_y = 0

dic = defaultdict(int)

for i in range(N):
    a,b = map(int,input().split())

    if a == 0:
        if b > 0:
            p_y += 1
        else:
            y += 1
    elif b == 0:
        if a > 0:
            p_x += 1
        else:
            x += 1
    else:
        v = gcd(a, b)
        a //= v
        b //= v
        if (a,b) in dic:
            dic[(a,b)] += 1
        else:
            dic[(a,b)] = 1

m = max(dic.values())
print(max(m, x, y,p_y,p_x))

