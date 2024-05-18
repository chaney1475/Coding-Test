T = int(input())

dx = [0,0,1,-1]
dy = [1,-1,0,0]

def make_num(s,x,y):
    if len(s) == 7:
        a.add(s)
        return

    for ii in range(4):
        nx = dx[ii] + x
        ny = dy[ii] + y
        if ny < 0 or ny >= 4 or nx < 0 or nx >= 4:
            continue
        make_num(s+str(board[nx][ny]), nx, ny)


for t in range(1,T+1):
    board = []
    for _ in range(4):
        board.append(list(map(int,input().split())))
    a = set()

    for i in range(4):
        for j in range(4):
            make_num("",i,j)

    print(f"#{t} {len(a)}")