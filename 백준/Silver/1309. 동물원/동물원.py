import sys
input = sys.stdin.readline

MOD = 9901
A = 1
B = 1
C = 1
cnt = 0
N = int(input())

while cnt < N:
    a = (A + B + C) % MOD
    b = (A + C) % MOD
    c = (A + B) % MOD
    A, B, C = a, b, c
    cnt += 1


print(A)
