import sys
from collections import deque

input = sys.stdin.readline

#전체 F층 S에서 시작 G에서 도착
F,S,G,U,D = map(int,input().split())
dp = [sys.maxsize] * (F+1)

def bfs(start):
    q = deque()
    q.append([start,0])
    dp[start] = 0
    while q:
        now, cnt = q.popleft()
        if now == G:
            return
        if now + U <= F and dp[now + U] > cnt + 1:
            dp[now + U] = cnt + 1
            q.append([now+U,cnt+1])
        if now - D >= 1 and dp[now - D] > cnt + 1:
            dp[now - D] = cnt +1
            q.append([now-D,cnt+1])

bfs(S)
if dp[G] == sys.maxsize:
    print("use the stairs")
else:
    print(dp[G])