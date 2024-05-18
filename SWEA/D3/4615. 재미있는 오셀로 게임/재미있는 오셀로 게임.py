T = int(input())


dx = [-1,-1,-1,0,0, 1,1,1]
dy = [-1, 0, 1,-1,1,-1,0,1]


def play():
    for x, y, color in put:

        A[x][y] = color
        op = 1 if color == 2 else 2

        for i in range(8):
            nx = dx[i] + x
            ny = dy[i] + y
            #다음 돌확인
            if nx < 0 or nx >= N and ny < 0 or ny >= N:
                continue
            temp = []
            while 0 <= nx < N and 0 <= ny < N and A[nx][ny] == op:
                temp.append([nx,ny])
                nx = dx[i] + nx
                ny = dy[i] + ny
            #반복문에서 나가고 다음돌이 현재 색과 일치하는지
            if 0 <= nx < N and 0 <= ny < N and A[nx][ny] == color:
                for tx, ty in temp:
                    A[tx][ty] = color

def cnt_color():
    black = 0
    white = 0

    for i in range(N):
        for j in range(N):
            if A[i][j] == 1:
                black += 1
            elif A[i][j] == 2:
                white += 1

    return black, white



for t in range(1,T+1):
    N, M = map(int, input().split())

    A = [[0] * N for _ in range(N)] #보드
    A[N//2-1][N//2-1] = 2
    A[N//2][N//2] = 2
    A[N//2-1][N//2] = 1
    A[N//2][N//2-1] = 1

    put = [] #돌놓기
    for _ in range(M):
        y,x,c = map(int, input().split())
        #1 흑돌, 2 백돌
        put.append([x-1,y-1,c])
    play()
    a,b = cnt_color()
    print(f"#{t} {a} {b}")

