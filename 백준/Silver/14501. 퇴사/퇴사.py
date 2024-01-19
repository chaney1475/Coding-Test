import sys

input = sys.stdin.readline

N = int(input())
A = []

answer = 0


def DFS(x, total):
    global answer
    if total > answer:
        answer = total

    for i in range(x + A[x][0], N):
        if (N - i) >= A[i][0]:
            DFS(i, total + A[i][1])


for _ in range(N):
    a, b = map(int, input().split())
    A.append((a, b))

for i in range(0, N):
    if (N-i) >= A[i][0]:
        DFS(i, A[i][1])

print(answer)
