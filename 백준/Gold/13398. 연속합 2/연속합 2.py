import sys
input = sys.stdin.readline

N = int(input())

D = [[-sys.maxsize, -sys.maxsize] for _ in range (100000+1)]

A = [-sys.maxsize]
A += list(map(int, input().split()))


ends = -sys.maxsize
#끝까지 안찾는 경우에 ends에 저장 -> 뒤가 다 음수인 경우

for i in range(1,N+1):
    if A[i] < 0:
        big = max(D[i-1][0], D[i-1][1])
        ends = max(ends,big)
    D[i][0] = max(D[i-1][0] + A[i], A[i])
    D[i][1] = max(D[i-1][0], D[i-1][1] + A[i])

print(max(ends, D[N][0],D[N][1]))

