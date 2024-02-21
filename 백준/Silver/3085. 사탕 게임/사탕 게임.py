import sys

input = sys.stdin.readline

N = int(input())

A = []
for n in range(N):
    A.append(list(input().rstrip()))

biggest = 1

def check_r(n):
    global biggest
    before = A[n][0]
    cnt = 1
    for i in range(1, N):
        if before == A[n][i]:
            cnt += 1
        else:
            if biggest < cnt:
                biggest = cnt
            cnt = 1
        before = A[n][i]

    if biggest < cnt:
        biggest = cnt


def check_c(n):
    global biggest
    before = A[0][n]
    cnt = 1
    for i in range(1, N):
        if before == A[i][n]:
            cnt += 1
        else:
            if biggest < cnt:
                biggest = cnt
            cnt = 1
        before = A[i][n]

    if biggest < cnt:
        biggest = cnt


# 가로 보기
for i in range(N):
    for j in range(N):
        if j + 1 < N:
            A[i][j], A[i][j + 1] = A[i][j + 1], A[i][j]
            check_r(i)
            A[i][j], A[i][j + 1] = A[i][j + 1], A[i][j]
        if 0 <= i - 1:
            A[i][j], A[i - 1][j] = A[i - 1][j], A[i][j]
            check_r(i)
            A[i][j], A[i - 1][j] = A[i - 1][j], A[i][j]
        if i + 1 < N:
            A[i][j], A[i + 1][j] = A[i + 1][j], A[i][j]
            check_r(i)
            A[i][j], A[i + 1][j] = A[i + 1][j], A[i][j]

# 세로
for j in range(N):
    for i in range(N):
        if i + 1 < N:
            A[i][j], A[i + 1][j] = A[i + 1][j], A[i][j]
            check_c(j)
            A[i][j], A[i + 1][j] = A[i + 1][j], A[i][j]
        if 0 <= j - 1:
            A[i][j - 1], A[i][j] = A[i][j], A[i][j - 1]
            check_c(j)
            A[i][j - 1], A[i][j] = A[i][j], A[i][j - 1]
        if j + 1 < N:
            A[i][j], A[i][j + 1] = A[i][j + 1], A[i][j]
            check_c(j)
            A[i][j], A[i][j + 1] = A[i][j + 1], A[i][j]

print(biggest)
