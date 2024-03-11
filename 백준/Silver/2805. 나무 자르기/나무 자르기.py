import sys
input = sys.stdin.readline


N, M = map(int,input().split())

tree = list(map(int, input().split()))

start = 1
end = max(tree)

answer = 0


while start <= end:
    mid = (start + end) // 2
    total = 0
    for i in range(N):
        if tree[i] > mid:
            total += (tree[i] - mid)

    if total >= M:
        answer = mid
        start = mid + 1
    else:
        end = mid - 1

print(answer)
