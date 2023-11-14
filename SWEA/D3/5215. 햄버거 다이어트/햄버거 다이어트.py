test_case = int(input())


def dfs(index, x, temp):
    global sum

    for j in range(index,N):
        if not visited[j] and x >= material[j][1]:
            visited[j] = True
            dfs(j+1, x - material[j][1], temp + material[j][0]) #길이가 가능하면 값 빼고 dfs
            visited[j] = False

    if sum < temp:
        sum = temp

for i in range(test_case):

    # N이 종류 l이 제한 길이
    N, L = map(int, input().split())

    visited = [False] * N

    sum = 0
    material = []
    for j in range(N):
        a, b = map(int, input().split())
        material.append((a, b))

    dfs(0, L, 0)

    print(f"#{i+1} {sum}")