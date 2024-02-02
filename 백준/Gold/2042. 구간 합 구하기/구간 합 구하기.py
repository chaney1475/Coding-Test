import sys

input = sys.stdin.readline

# 숫자 갯수, 변경횟수, 구간합을 물어보는 횟수
N, M, K = map(int, input().split())

a = []
for _ in range(N):
    a.append(int(input()))


def get_k():
    amount = 1
    while amount < len(a):
        amount *= 2
    return amount


num_k = get_k()
tree = [0] * (num_k * 2)

for i in range(0, len(a)):
    tree[num_k + i] = a[i]


def init_tree(start, end):
    while start < end:
        for i in range(start, end + 1):
            tree[i // 2] += tree[i]
        start = start // 2
        end = end // 2


init_tree(num_k, num_k * 2 - 1)


def update(i, change):
    # i번째 수를 c로 바꾸기
    i = i + num_k - 1
    dif = change - tree[i]
    tree[i] = change
    while i > 0:
        i = i // 2
        tree[i] += dif


def tree_sum(start, end):
    p_sum = 0
    start = start + num_k - 1
    end = end + num_k - 1
    while start <= end:
        if start % 2 == 1:
            p_sum += tree[start]
            start += 1
        if end % 2 == 0:
            p_sum += tree[end]
            end -= 1
        start = start // 2
        end = end // 2
    return p_sum

for i in range(M + K):
    a, b, c = map(int, input().split())
    if a == 1:
        update(b, c)
    else:
        # b부터 c까지의 합 출력하기
        total = tree_sum(b, c)
        print(total)
