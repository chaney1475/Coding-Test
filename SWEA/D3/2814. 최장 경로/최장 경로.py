T = int(input())


def dfs(cnt, start):
    global l_node
    global l_cnt
    if cnt > l_cnt:
        l_node = start
        l_cnt = cnt
    for i in node[start]:
        if not visited[i]:
            visited[i] = True
            dfs(cnt + 1, i)
            visited[i] = False



for t in range(1,T+1):
    N, M = map(int, input().split())
    node = [[] for _ in range(N+1)]

    for _ in range(M):
        a,b = map(int,input().split())
        node[a].append(b)
        node[b].append(a)


    visited = [False] * (N + 1)
    l_cnt = -1
    l_node = -1
    visited[1] = True
    dfs(1,1)

    starts = l_node
    l_cnt = -1
    l_node = -1
    visited = [False] * (N + 1)
    visited[starts] = True
    dfs(1, starts)
    print(f"#{t} {l_cnt}")
