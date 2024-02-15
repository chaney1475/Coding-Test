import sys
input = sys.stdin.readline

D = [[sys.maxsize] * 3 for _ in range(1001)]

N = int(input())
cost = []

for _ in range(N):
    cost.append(list(map(int, input().split())))

#1번째 줄 -> A[1-1]
for i in range(3):
    D[1][i] = cost[0][i]

for i in range(3):
    for j in range(3):
        if i == j:
            continue
        #cost는 무조건 -1해서 계산
        D[2][i] = min(D[2][i], D[1][j] + cost[1][i])

#k번째 집부터 찾기
k = 3
while k < N+1:

    D[k][0] = min(D[k - 1][2] + cost[k - 1][0],
                  D[k - 1][1] + cost[k - 1][0])

    D[k][1] = min(D[k - 1][0] + cost[k - 1][1],
                  D[k - 1][2] + cost[k - 1][1])

    D[k][2] = min(D[k - 1][0] + cost[k - 1][2],
                  D[k - 1][1] + cost[k - 1][2])
    k += 1


print(min(D[N]))

