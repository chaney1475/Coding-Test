import sys

input = sys.stdin.readline

N = int(input())

board = []

for _ in range(N):
    board.append(list(map(int, input().split())))

answer = 0

def make_newL(l):
    newL = []
    for n in l:
        if n != 0:
            newL.append(n)
    return newL

def make_CnewL(board, j):
    newL = []
    for i in range(N):
        if board[i][j] != 0:
            newL.append(board[i][j])
    return newL

def check(board):
    global answer
    for i in range(N):
        answer = max(answer, max(board[i]))


def dfs(cnt, board):
    if cnt == 5:
        check(board)
        return
    # 기존보드
    copy_board = [[i for i in board[j]] for j in range(N)]

    # 왼쪽으로 밀기
    for i in range(N):
        c = make_newL(copy_board[i])
        new_l = push(c)
        for h in range(N):
            copy_board[i][h] = new_l[h]

    dfs(cnt + 1, copy_board)

    copy_board = [[i for i in board[j]] for j in range(N)]
    # 오른쪽으로 밀기
    for i in range(N):
        c = make_newL(copy_board[i])
        new_l = push(c[::-1])[::-1]
        for h in range(N):
            copy_board[i][h] = new_l[h]

    dfs(cnt + 1, copy_board)

    copy_board = [[i for i in board[j]] for j in range(N)]
    # 위로 밀기

    for i in range(N):
        c = make_CnewL(copy_board, i)
        new_l = push(c)
        for h in range(N):
            copy_board[h][i] = new_l[h]
    dfs(cnt + 1, copy_board)

    copy_board = [[i for i in board[j]] for j in range(N)]

    # 아래로 밀기
    for i in range(N):
        c = make_CnewL(copy_board,i)
        new_l = push(c[::-1])[::-1]

        for h in range(N):
            copy_board[h][i] = new_l[h]

    dfs(cnt + 1, copy_board)


def push(c):
    new_l = []
    if len(c) == 1:
        new_l = c
    j = 1
    while j < len(c):
        if c[j - 1] == c[j]:
            new_l.append(c[j] * 2)
            if j == len(c) - 2:
                new_l.append(c[j + 1])
            j += 2

        else:
            new_l.append(c[j - 1])
            if j == len(c) - 1:
                new_l.append(c[j])
            j += 1
    k = len(new_l)

    for _ in range(N - k):
        new_l.append(0)
    return new_l


if N == 1:
    answer = board[0][0]
else:
    dfs(0,board)

print(answer)

