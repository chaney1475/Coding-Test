import sys
import math
input = sys.stdin.readline

s = input().rstrip()
t = input().rstrip()

common_l = math.gcd(len(s),len(t))
common = ""

for i in range(common_l):
    if s[i] == t[i]:
        common += s[i]
    else:
        break

common_l = len(common)

def check(S):
    if common_l == 0 or len(S) % common_l != 0:
        return False
    for i in range(len(S)):
        if S[i] != common[i % common_l]:
            return False
    return True


if check(s) and check(t):
    print(1)
else:
    print(0)