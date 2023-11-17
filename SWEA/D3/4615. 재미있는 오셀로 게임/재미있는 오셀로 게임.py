#오셀로

t = int(input())


def check_my_color(x, y, i, j, color):
    while 1 <= x + i <= N and 1 <= y + j <= N:
        x += i
        y += j
        if A[x][y] == color:
            return True
        elif A[x][y] == 0:
            return False
    return False


def change(x, y, i, j, color, other):
    while 1 <= x + i <= N and 1 <= y + j <= N:
        x += i
        y += j
        if A[x][y] == other:
            A[x][y] = color
        else:
            return


def check(x, y, color):

    grid = [0, -1, 1]

    if color == 2:
        other = 1
    elif color == 1:
        other = 2

    flag = 0
    for i in grid:
        for j in grid:
            if not (i == 0 and j == 0):
                if 1 <= x + i <= N and 1 <= y + j <= N and A[x + i][y + j] == other:
                    if check_my_color(x, y, i, j, color):
                        change(x, y, i, j, color, other)
                        flag = 1
    if flag == 1:
        return True


for test_case in range(1,t+1):

    #변의 길이 , 횟수
    N, M = map(int, input().split())

    A = [[0] * (N+1) for _ in range(N+1)]
    n = N // 2

    A[n][n], A[n][n+1], A[n+1][n], A[n+1][n+1] = 2,1,1,2

    for _ in range(M):
        a, b, color = map(int, input().split())
        if A[a][b] == 0 and check(a, b, color):
            A[a][b] = color

    w = 0
    b = 0

    for i in range(1, N+1):
        for j in range(1, N+1):
            if A[i][j] == 2:
                w += 1
            elif A[i][j] == 1:
                b += 1
    print(f"#{test_case} {b} {w}")
