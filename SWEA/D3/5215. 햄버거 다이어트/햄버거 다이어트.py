T = int(input())

def check():
    #하나의 버거에 대해서 더 작은 값이면
    score, cal = burger[0]

    #초기화
    for j in range(0,L+1):
        if cal <= j:
            dp[0][j] = score

    for i in range(1,len(burger)):
        score, cal = burger[i]
        for j in range(0,L+1):
            if j < cal:
                dp[i][j] = dp[i-1][j]
            else:
                dp[i][j] = max(dp[i-1][j], dp[i-1][j-cal] + score)


for t in range(1,T+1):
    N, L = map(int, input().split())
    dp = [[0] * (L+1) for _ in range(N)]
    burger = []
    for _ in range(N):
        #점수, 칼로리
        a,b = map(int, input().split())
        burger.append([a,b])
    check()
    answer = max(dp[N-1])
    print(f"#{t} {answer}")