import sys
import math
input = sys.stdin.readline

T = int(input())

for _ in range(T):
    N, M, x, y = map(int, input().split())
    answer = -1
    common = math.gcd(N,M)
    max_n = N * M // common
    for i in range(max_n // M):
        if (i * M + y - x) % N == 0:
            answer = i * M + y
            break
    print(answer)


