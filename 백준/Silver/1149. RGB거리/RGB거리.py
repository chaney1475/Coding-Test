import sys

input = sys.stdin.readline

N = int(input())
dp = [[sys.maxsize] * 3 for _ in range(N)]

RGB = []
for i in range(N):
    RGB.append(list(map(int, input().split())))

dp[0][0] = RGB[0][0]
dp[0][1] = RGB[0][1]
dp[0][2] = RGB[0][2]

for i in range(1, N):
    dp[i][0] = min(dp[i - 1][1], dp[i - 1][2]) + RGB[i][0]
    dp[i][1] = min(dp[i - 1][0], dp[i - 1][2]) + RGB[i][1]
    dp[i][2] = min(dp[i - 1][0], dp[i - 1][1]) + RGB[i][2]

print(min(dp[N-1]))