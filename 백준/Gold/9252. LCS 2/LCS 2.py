import sys
sys.setrecursionlimit(100000)
input = sys.stdin.readline

A = input().rstrip()
B = input().rstrip()

D = [[0] * (len(B) + 1) for _ in range(len(A) + 1)]

for i in range(1, len(A) + 1):
    for j in range(1, len(B) + 1):
        if A[i - 1] == B[j - 1]:
            D[i][j] = D[i - 1][j - 1] + 1
        else:
            D[i][j] = max(D[i - 1][j], D[i][j - 1])

answer = D[len(A)][len(B)]

print(answer)

path = []


def get_cs(r, c):
    if r == 0 or c == 0:
        return
    if A[r - 1] == B[c - 1]:
        path.append(A[r - 1])
        get_cs(r-1, c-1)
    else:
        if D[r - 1][c] > D[r][c - 1]:
            get_cs(r - 1, c)
        else:
            get_cs(r, c - 1)


get_cs(len(A), len(B))
print("".join(path[::-1]))
