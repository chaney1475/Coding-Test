import sys

sys.setrecursionlimit(1000000)
input = sys.stdin.readline

N = int(input())
MOD = 1000000000

D = [0] * (1000001)
D[2] = 1


for i in range(3,N+1):
    D[i] = (i - 1) * (D[i - 1] + D[i - 2]) % MOD

print(D[N])
