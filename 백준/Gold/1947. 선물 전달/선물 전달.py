import sys
sys.setrecursionlimit(1000000)
input = sys.stdin.readline

N = int(input())
MOD = 1000000000

D = [0] * (N + 3)
D[1] = 0
D[2] = 1
D[3] = 2


def dp(n):
    if n < 2:
        return 0
    if D[n] == 0:
        D[n] = (n - 1)*(dp(n - 1) + dp(n - 2))% MOD
    return D[n]


print(dp(N))
