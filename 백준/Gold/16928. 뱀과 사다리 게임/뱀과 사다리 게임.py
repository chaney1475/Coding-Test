import sys
from collections import deque
input = sys.stdin.readline

N, M = map(int, input().split())

d = dict()

for _ in range(N+M):
    a,b = map(int, input().split())
    d[a] = b

dp = [sys.maxsize] * 100

def bfs():
    q = deque()
    q.append((1, 0))
    dp[1] = 0
    while q:
        point, cnt = q.popleft()
        if point in d:
            point = d[point]
        for i in range(1,7):
            if dp[(point+i) % 100] > cnt + 1:
                dp[(point+i) % 100] = cnt + 1
                q.append(((point + i) % 100, cnt+1))

bfs()
print(dp[0])