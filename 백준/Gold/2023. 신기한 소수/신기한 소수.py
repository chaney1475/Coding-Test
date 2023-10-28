import sys
sys.setrecursionlimit(10000)
input = sys.stdin.readline

N = int(input().rstrip())

K = [1, 3, 5, 7, 9]


def prime(n):
    for i in range(2, n // 2 + 1):
        if n % i == 0:
            return False
    return True


def DFS(v):
    if len(str(v)) == N:
        print(v)
    else:
        for i in K:
            if prime(v * 10 + i):
                DFS(v * 10 + i)

DFS(2)
DFS(3)
DFS(5)
DFS(7)