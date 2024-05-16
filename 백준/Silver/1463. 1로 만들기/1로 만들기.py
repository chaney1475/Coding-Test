import sys
from collections import deque
input = sys.stdin.readline

N = int(input())
dp = [sys.maxsize] * 1000001


def make_one():
    q = deque()
    q.append(N)
    dp[N] = 0
    while q:
        n = q.popleft()
        if n == 1:
            print(dp[n])
            return
        if n % 2 == 0 and dp[n//2] > dp[n] + 1:
            dp[n//2] = dp[n] + 1
            q.append(n//2)
        if n % 3 == 0 and dp[n//3] > dp[n] + 1:
            dp[n//3] = dp[n] + 1
            q.append(n//3)
        if n - 1 > 0 and dp[n-1] > dp[n] + 1:
            dp[n-1] = dp[n] + 1
            q.append(n-1)

make_one()