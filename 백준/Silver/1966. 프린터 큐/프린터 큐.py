from collections import deque
import sys

input = sys.stdin.readline

batch = int(input())

for _ in range(batch):
    N, M = map(int, input().split())

    dq = deque(list(map(int, input().split())))
    cnt = 0
    while dq:
        best = max(dq)
        i = dq.popleft()
        if i == best:
            cnt += 1
            if M == 0:
                break
        else:
            dq.append(i)

        M -= 1
        if M == -1:
            M = len(dq) - 1
    print(cnt)
