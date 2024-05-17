T = int(input())


def make(v):
    for i in range(N):
        for j in range(i + 1, N):
            if v[j] == v[i] + (j - i):
                return False
        for j in range(i - 1, -1, -1):
            if v[j] == v[i] + (i - j):
                return False
    return True


def q_order(l):
    global cnt
    if len(l) == N:
        if make(l):
            cnt += 1
        return

    for i in range(N):
        if not visited[i]:
            visited[i] = True
            q_order(l + [i])
            visited[i] = False


for t in range(1, 1 + T):
    N = int(input())
    cnt = 0
    visited = [False] * N
    q_order([])
    print(f'#{t} {cnt}')
