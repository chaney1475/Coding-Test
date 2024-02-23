import sys

input = sys.stdin.readline

N, M = map(int, input().split())

A = []

for _ in range(N):
    A.append(list(map(int, input().split())))

row = [(0, -1), (-1, 0), (-1, 1), (1, 0), (1, 1), (0, 2)]

col = [(-1, 0), (0, -1), (0, 1), (1, -1), (1, 1), (2, 0)]


def check_row(a, b):
    total = 0
    center = A[a][b] + A[a][b + 1]
    for i in range(6):
        for j in range(i + 1, 6):
            if 0 <= row[i][0] + a < N and 0 <= row[i][1] + b < M and 0 <= row[j][0] + a < N and 0 <= row[j][1] + b < M:
                temp = A[row[i][0] + a][row[i][1] + b] + A[row[j][0] + a][row[j][1] + b]
                if temp > total:
                    total = temp
    return total + center


def check_col(a, b):
    total = 0
    center = A[a][b] + A[a+1][b]
    for i in range(6):
        for j in range(i + 1, 6):
            if 0 <= col[i][0] + a < N and 0 <= col[i][1] + b < M and 0 <= col[j][0] + a < N and 0 <= col[j][1] + b < M:
                temp = A[col[i][0] + a][col[i][1] + b] + A[col[j][0] + a][col[j][1] + b]
                if temp > total:
                    total = temp
    return total + center


answer = 0
for i in range(N):
    for j in range(M - 1):
        answer = max(answer, check_row(i, j))

for i in range(M):
    for j in range(N - 1):
        answer = max(answer, check_col(j, i))

print(answer)
