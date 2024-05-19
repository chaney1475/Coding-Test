T = int(input())
from itertools import combinations


def check(x):
    start = 10
    while x != 0:
        if start < x % 10:
            return False
        start = x % 10
        x = x // 10
    return True


for t in range(1, T + 1):
    N = int(input())
    index = [i for i in range(N)]
    combs = list(combinations(index, 2))
    num = list(map(int, input().split()))
    max_ans = -1
    for a, b in combs:
        tmp = num[a] * num[b]
        if tmp > max_ans and check(tmp):
            max_ans = tmp

    print(f"#{t} {max_ans}")
