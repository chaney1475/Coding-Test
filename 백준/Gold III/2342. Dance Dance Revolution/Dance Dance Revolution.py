import sys

input = sys.stdin.readline

w = [[0, 2, 2, 2, 2],
     [2, 1, 3, 4, 3],
     [2, 3, 1, 3, 4],
     [2, 4, 3, 1, 3],
     [2, 3, 4, 3, 1]]

p = list(map(int, input().split()))
D = [[[sys.maxsize] * 5 for _ in range(5)] for _ in range(100001)]

D[0][0][0] = 0

index = 0

while p[index] != 0:
    n = p[index]
    for i in range(5):
        if i == n:
            continue
        for j in range(5):
            D[index + 1][i][n] = min(D[index][i][j] + w[j][n], D[index + 1][i][n])
    for j in range(5):
        if n == j:
            continue
        for i in range(5):
            D[index + 1][n][j] = min(D[index][i][j] + w[i][n], D[index + 1][n][j])
    index += 1

result = sys.maxsize

for i in range(5):
    for j in range(5):
        result = min(result, D[index][i][j])

print(result)
