import sys

input = sys.stdin.readline

P_n = int(input())
S_n = int(input())

S = input().rstrip()


def make_p(x):
    p = "IOI"
    k = 1
    while k < x:
        p += "OI"
        k += 1
    return p


P = make_p(P_n)
l = len(P)
cnt = 0
for i in range(l-1, S_n):
    if S[i - l + 1:i+1] == P:
        cnt += 1
        i += 1

print(cnt)
