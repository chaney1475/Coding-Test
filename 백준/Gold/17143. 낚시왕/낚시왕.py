import sys

input = sys.stdin.readline

# 격자 크기, 상어 수
N, M, S = map(int, input().split())

board = [[0]*M for _ in range(N)]

for _ in range(S):
    r, c, s, d, z = map(int, input().split())
    board[r - 1][c - 1] = [s, d, z]  # 속력,이동방향,상어 크기


def move_shark(temp, x, y, bb):
    speed, direct, cost = bb
    move = speed
    if direct == 1 or direct == 2:
        while move != 0:
            if direct == 1:
                if move <= x:
                    x -= move
                    move = 0
                else:
                    move = move - x
                    x = 0
                    direct = 2
            else:
                if move + x < N:
                    x = move + x
                    move = 0
                else:
                    move = move - (N - 1 - x)
                    x = N - 1
                    direct = 1
    else:
        while move != 0:
            if direct == 4:
                if move <= y:
                    y -= move
                    move = 0
                else:
                    move = move - y
                    y = 0
                    direct = 3
            else:
                if move + y < M:
                    y = move + y
                    move = 0
                else:
                    move = move - (M - 1 - y)
                    y = M - 1
                    direct = 4
    if temp[x][y] != 0:
        if temp[x][y][2] < cost:
            temp[x][y] = [speed, direct, cost]
    else:
        temp[x][y] = [speed, direct, cost]


def swim():
    temp = [[0] * M for _ in range(N)]
    for k in range(N):
        for p in range(M):
            if board[k][p] != 0:
                move_shark(temp, k, p, board[k][p])
    return temp

answer = 0
if S == 0:
    print(0)
    sys.exit()

for j in range(M):
    for i in range(N):
        if board[i][j] != 0:
            answer += board[i][j][2]
            board[i][j] = 0
            break
    board = swim()

print(answer)
