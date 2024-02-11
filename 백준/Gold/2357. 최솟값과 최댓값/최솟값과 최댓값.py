import sys

input = sys.stdin.readline

N, M = map(int, input().split())

t = 1
while t < N:
    t *= 2

h_tree = [-1] * (t * 2)
l_tree = [sys.maxsize] * (t * 2)

for i in range(N):
    n = int(input())
    h_tree[i + t] = n
    l_tree[i + t] = n


for i in range(t - 1, 0, -1):
    h_tree[i] = max(h_tree[i * 2], h_tree[i * 2 + 1])
    l_tree[i] = min(l_tree[i * 2], l_tree[i * 2 + 1])


def find_h(s, e):
    h = -1
    while s <= e:
        if s % 2 == 1:
            h = max(h, h_tree[s])
            s += 1
        if e % 2 == 0:
            h = max(h, h_tree[e])
            e -= 1

        s = s // 2
        e = e // 2


    return h


def find_l(s, e):
    l = sys.maxsize
    while s <= e:
        if s % 2 == 1:
            l = min(l, l_tree[s])
            s += 1
        if e % 2 == 0:
            l = min(l, l_tree[e])
            e -= 1
        s = s // 2
        e = e // 2

    return l


for i in range(M):
    a, b = map(int, input().split())
    print(find_l(a - 1 + t, b - 1 + t), end=" ")
    print(find_h(a - 1 + t, b - 1 + t))
