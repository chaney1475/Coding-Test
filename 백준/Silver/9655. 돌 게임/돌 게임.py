import sys
input = sys.stdin.readline

N = int(input())

K = N // 3
K += (N % 3)

if K % 2 == 0:
    print("CY")
else:
    print("SK")