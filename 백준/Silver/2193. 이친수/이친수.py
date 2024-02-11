import sys
input = sys.stdin.readline

N = int(input())

D = [0] * (90+1)
D[1] = 1
D[2] = 1
for i in range(3,91):
    D[i] = D[i-1] +D[i-2]

print(D[N])
