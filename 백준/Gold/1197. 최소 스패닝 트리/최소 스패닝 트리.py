import sys

input = sys.stdin.readline
import heapq

N, M = map(int, input().split())

A = []
rep = [i for i in range(N + 1)]


def find(i):
    if rep[i] != i:
        rep[i] = find(rep[i])
    return rep[i]


def uni(a, b):
    A = find(a)
    B = find(b)
    if A < B:
        rep[B] = A
    else:
        rep[A] = B


for _ in range(M):
    a, b, w = map(int, input().split())
    heapq.heappush(A, (w, a, b))

total = 0
cnt = 0
while A:
    # 가중치, 시작, 끝
    w, a, b = heapq.heappop(A)
    if find(a) != find(b):
        uni(a, b)
        total += w
        cnt += 1
        if cnt == N-1:
            break

print(total)
