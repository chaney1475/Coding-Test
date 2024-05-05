import sys

# 입력 받기
n, k = map(int, input().split())
coins = [int(input()) for _ in range(n)]

# DP 테이블 초기화
dp = [sys.maxsize] * (k + 1)
dp[0] = 0

# 동전을 사용하여 k원을 만들 수 있는 최소 동전 개수 계산
for coin in coins:
    for j in range(coin, k + 1):
        dp[j] = min(dp[j], dp[j - coin] + 1)

# 결과 출력
if dp[k] == sys.maxsize:
    print(-1)
else:
    print(dp[k])
