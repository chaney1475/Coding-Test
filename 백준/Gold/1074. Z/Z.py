import sys

input = sys.stdin.readline


N, a, b = map(int, input().split())


answer = 0
def square(n, x, y):

    global answer
    if n == 0:
        return

    if 0 <= x < 2 ** (n-1):
        if 0 <= y < 2 ** (n-1):
            square(n-1, x,y)
        else:
            answer += 2 ** (2*n -2)
            square(n-1,x,y - (2 ** (n-1)))
    else:
        if 0 <= y < 2 ** (n - 1):
            answer += 2 * (2 ** (2*n -2))
            square(n - 1, x - (2 ** (n - 1)), y)
        else:
            answer += 3 * (2 ** (2 * n - 2))
            square(n - 1, x - (2 ** (n - 1)), y - (2 ** (n - 1)))


square(N,a,b)
print(answer)

