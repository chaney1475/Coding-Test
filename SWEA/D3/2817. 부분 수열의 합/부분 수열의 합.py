T = int(input())


def dfs(start, tmp):
    global answer

    if start == N - 1:
        # 마지막 인덱스에 다다름
        if tmp == K:
            answer += 1
        return
    dfs(start + 1, tmp)
    dfs(start + 1, tmp + A[start + 1])


for t in range(1, T + 1):
    N, K = map(int, input().split())
    # 수열
    A = list(map(int, input().split()))
    visited = [False] * N
    answer = 0
    dfs(-1, 0)
    print(f"#{t} {answer}")
