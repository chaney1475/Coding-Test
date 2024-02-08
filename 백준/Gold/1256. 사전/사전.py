import sys

input = sys.stdin.readline

N, M, K = map(int, input().split())
total = N+M
A = [[0] * (i+2) for i in range(N+M+2)]

for i in range(1,N+M+2):
    A[i][i] = 1
    A[i][1] = i
    A[i][0] = 1


for j in range(3, N+M+2):
    for i in range(2,j):
        A[j][i] = A[j-1][i] + A[j-1][i-1]

def makeWord(K):
    answer = ""
    t = total
    n = N
    m = M

    while t > 0:
        t -= 1
        # a가 앞에 오는 경우
        if A[t][n - 1] >= K:
            answer += 'a'
            n -= 1
        else:
            K -= A[t][n - 1]
            m -= 1
            answer += 'z'
        if n == 0 or m == 0:
            break

    while n != 0:
        answer += 'a'
        n -= 1

    while m != 0:
        answer += 'z'
        m -= 1
    return answer


if A[total][N] < K:
    print(-1)
else:
    print(makeWord(K))