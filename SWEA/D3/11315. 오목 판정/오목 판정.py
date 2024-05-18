T = int(input())

def check():
    # 가로
    for i in range(N):
        cnt = 0
        for j in range(N):
            if A[i][j] == 'o':
                cnt += 1
                if cnt >= 5:
                    return "YES"
            else:
                cnt = 0

    # 세로
    for i in range(N):
        cnt = 0
        for j in range(N):
            if A[j][i] == 'o':
                cnt += 1
                if cnt >= 5:
                    return "YES"
            else:
                cnt = 0

    # 우하향 대각선 (main diagonal)
    for i in range(N):
        for j in range(N):
            cnt = 0
            x, y = i, j
            while x < N and y < N:
                if A[x][y] == 'o':
                    cnt += 1
                    if cnt >= 5:
                        return "YES"
                else:
                    cnt = 0
                x += 1
                y += 1

    # 좌하향 대각선 (anti-diagonal)
    for i in range(N):
        for j in range(N):
            cnt = 0
            x, y = i, j
            while x < N and y >= 0:
                if A[x][y] == 'o':
                    cnt += 1
                    if cnt >= 5:
                        return "YES"
                else:
                    cnt = 0
                x += 1
                y -= 1

    return "NO"

for t in range(1, T + 1):
    N = int(input())
    A = []
    for _ in range(N):
        A.append(list(input().rstrip()))
    print(f"#{t} {check()}")
