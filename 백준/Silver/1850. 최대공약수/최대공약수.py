import sys
input = sys.stdin.readline

M, N = map(int, input().split())

while N % M != 0:
    N = N % M
    M, N = N, M

A = [1] * M
print(''.join(map(str, A)))