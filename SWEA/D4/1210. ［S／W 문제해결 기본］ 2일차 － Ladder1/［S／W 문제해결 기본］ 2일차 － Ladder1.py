T = 10
dx = [0,0,1]
dy = [-1,1,0]

def slide(x,y):
    global answer
    visited = [[False] * 100 for _ in range(100)]
    visited[x][y] = True

    while 0 <= x < 100 and 0 <= y < 100:
        if x == 99:
            break
        for j in range(3):
            #좌우 먼저, 이후 아래로
            nx = dx[j] + x
            ny = dy[j] + y
            if 0 <= nx < 100 and 0 <= ny < 100 and A[nx][ny] == 1 and not visited[nx][ny]:
                visited[nx][ny] = True
                x = nx
                y = ny
                break
    answer = y


def check():
    sx, sy = 0,0
    for j in range(100):
        if A[0][j] == 2:
            sx, sy = i, j
            break
    slide(0,sy)




for t in range(1,T+1):
    t = int(input())
    A = []
    for i in range(100):
        A.append(list(map(int, input().split())))
    A.reverse()
    answer = -1
    check()
    print(f"#{t} {answer}")
