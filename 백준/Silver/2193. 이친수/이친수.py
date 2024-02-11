import sys
input = sys.stdin.readline

N = int(input())

D = [0] * (90+1)
D[1] = 1
D[2] = 1
D[3] = 2
D[4] = 3
for i in range(5,91):
    D[i] = D[i-2]*2 + D[i-3]

print(D[N])
