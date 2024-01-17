import sys
input = sys.stdin.readline
sys.setrecursionlimit(100000)

N, M = map(int, input().split())

A = [x for x in range(N + 1)]


def rep(a):
    if A[a] == a:
        return a
    else:
        A[a] = rep(A[a])
        return A[a]



for _ in range(M):
    k, a, b = map(int, input().split())
    # 합치기
    if k == 0:
        A[rep(b)] = rep(a)
    else:
        if rep(a) == rep(b):
            print("YES")
        else:
            print("NO")
