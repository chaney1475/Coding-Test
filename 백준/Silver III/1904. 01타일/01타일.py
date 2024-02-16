import sys
input = sys.stdin.readline

MOD = 15746

D = [0] * (1000000 +1)
D[1] = 1
D[2] = 2
N = int(input())
for i in range(3, N+1):
    D[i] = (D[i-2] + D[i-1]) % MOD

print(D[N])