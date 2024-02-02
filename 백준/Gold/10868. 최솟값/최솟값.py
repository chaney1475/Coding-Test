import sys

input = sys.stdin.readline

N, M = map(int, input().split())
# 숫자갯수, 몇번 출력할것인가

amount = 1
while amount <= N:
    amount *= 2

tree = [sys.maxsize] * (amount * 2)

for i in range(N):
    tree[i + amount] = int(input())


def init_tree(s, e):
    # 맨위는 계산안하니 <
    while s < e:
        for i in range(s, e+1):
            tree[i // 2] = min(tree[i // 2], tree[i])
        s = s // 2
        e = e // 2


init_tree(amount, amount * 2 - 1)


def min_n(s, e):
    min_num = sys.maxsize
    while s <= e:
        if s % 2 == 1:
            min_num = min(min_num, tree[s])
            s += 1
        if e % 2 == 0:
            min_num = min(min_num, tree[e])
            e -= 1
        s = s // 2
        e = e // 2

    return min_num


for m in range(M):
    a,b = map(int, input().split())
    print(min_n(a + amount - 1, b + amount - 1))

