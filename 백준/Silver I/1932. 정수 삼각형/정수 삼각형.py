import sys
input = sys.stdin.readline

N = int(input())

triangle = []
for _ in range(N):
    triangle.append(list(map(int,input().split())))

D = [[0]*(501) for i in range(501)]

D[0] = triangle[-1]

for i in range(1, N+1): # 점화식 채우기
    for j in range(N - i):
        D[i][j] = max(D[i-1][j], D[i-1][j+1]) + triangle[N-1-i][j]

print(D[N-1][0])
