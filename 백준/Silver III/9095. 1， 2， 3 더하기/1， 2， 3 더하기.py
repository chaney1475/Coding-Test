import sys

input = sys.stdin.readline

t = int(input())


def cal(a, b, c):
    t = a + b + c
    s = 1
    for i in range(1, t + 1):
        s *= i

    for i in range(2, a + 1):
        s //= i
    for i in range(2, b + 1):
        s //= i
    for i in range(2, c + 1):
        s //= i

    return s


def get_sum(N):
    total = 0

    for i in range(N // 3 + 1):
        n = N - (i * 3)
        for j in range(n // 2 + 1):
            m = n - (j * 2)
            total += cal(i, j, m)
    print(total)


for _ in range(t):
    get_sum(int(input()))
