import sys
input = sys.stdin.readline

R, C, T = map(int, input().split())

A = []
clean = []

for i in range(R):
    r = list(map(int, input().split()))
    for j in range(C):
        if r[j] == -1:
            clean.append((i,j))

    A.append(r)

dx = [0,0,-1,1]
dy = [1,-1,0,0]

def make_dust():
    temp = [[0] * C for _ in range(R)]
    for i in range(R):
        for j in range(C):
            if A[i][j] > 0:
                du = A[i][j] // 5
                for d in range(4):
                    nx = dx[d] + i
                    ny = dy[d] + j
                    if nx < 0 or nx >= R or ny < 0 or ny >= C or A[nx][ny] == -1:
                        continue
                    temp[nx][ny] += du
                    A[i][j] -= du

    for i in range(R):
        for j in range(C):
            if A[i][j] == -1:
                continue
            A[i][j] += temp[i][j]

def cleaning():
    a,b = clean[0]
    for i in range(a-1,0,-1):
        A[i][b] = A[i-1][b]

    for j in range(0,C-1):
        A[0][j] = A[0][j+1]

    for i in range(0,a):
        A[i][C-1] = A[i+1][C-1]

    for j in range(C-1,0,-1):
        A[a][j] = A[a][j-1]

    A[a][b+1] = 0

    c,d = clean[1]
    for i in range(c+1, R-1):
        A[i][0] = A[i+1][0]
    for j in range(0,C-1):
        A[R-1][j] = A[R-1][j+1]
    for i in range(R-1,c-1,-1):
        A[i][C-1] = A[i-1][C-1]
    for j in range(C-1,0,-1):
        A[c][j] = A[c][j-1]

    A[c][d+1] = 0

for _ in range(T):
    make_dust()
    cleaning()

answer = 0
for i in range(R):
    answer += sum(A[i])

print(answer + 2)

