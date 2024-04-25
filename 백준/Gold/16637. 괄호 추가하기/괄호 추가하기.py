import sys
input = sys.stdin.readline

N = int(input())
S = input().rstrip()

answer = 0
dp = [[0, 0] for _ in range(N)]
dp[0] = [int(S[0]), int(S[0])]

def check(a,cal,b):
    a = int(a)
    b = int(b)
    if cal == "+":
        return a+b
    elif cal == "-":
        return a-b
    else:
        return a*b

if N > 2:
    dp[2][0] = check(S[0], S[1], S[2])
    dp[2][1] = check(S[0], S[1], S[2])

for i in range(4,N,2):
    a = check(dp[i - 2][0], S[i - 1], S[i])
    b = check(dp[i - 4][0], S[i - 3], check(S[i - 2], S[i - 1], S[i]))
    c = check(dp[i - 2][1], S[i - 1], S[i])
    d = check(dp[i - 4][1], S[i - 3], check(S[i - 2], S[i - 1], S[i]))

    dp[i][0] = min(a, b, c, d)
    dp[i][1] = max(a, b, c, d)

print(max(dp[N - 1]))
