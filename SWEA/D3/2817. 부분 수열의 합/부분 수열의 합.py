# 부분수열의 합
t = int(input())


def dfs(index, sum):
    global answer

    if sum == 0:
        answer += 1
        return
    if index == N:
        return

    for i in range(index, N):
        if not visited[i] and sum >= A[i]:
            visited[i] = True
            dfs(i+1, sum - A[i])
            visited[i] = False


for test in range(1, t + 1):
    answer = 0
    N, K = map(int, input().split())
    A = list(map(int, input().split()))
    visited = [False] * N

    dfs(0, K)

    print(f"#{test} {answer}")
