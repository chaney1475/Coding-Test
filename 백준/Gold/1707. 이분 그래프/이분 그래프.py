import sys
sys.setrecursionlimit(10**6)
input = sys.stdin.readline
N = int(input())

IsEven = True

def DFS(node):
    global IsEven
    visited[node] = True
    for i in A[node]:
        if not visited[i]:
            check[i] = (check[node] + 1)%2
            DFS(i)
        elif check[node] == check[i]:
            IsEven = False


for _ in range(N):
    V, E = map(int, input().split())
    A = [[] for _ in range(V+1)]
    visited = [False] * (V+1) #방문 했는지
    check = [0] * (V+1) # 어떤 그룹인지
    IsEven = True
    for i in range(E):
        Start, End = map(int, input().split())
        A[Start].append(End)
        A[End].append(Start)
    for i in range(1, V+1):
        if IsEven:
            DFS(i)
        else:
            break

    if IsEven:
        print("YES")
    else:
        print("NO")

