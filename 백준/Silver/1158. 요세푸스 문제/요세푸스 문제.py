import sys
input = sys.stdin.readline

M, N = map(int, input().split())
A = [i for i in range(1,M+1)]
answer = []
i = 0
while A:
    i = (i + N-1) % len(A)
    answer.append(str(A.pop(i)))

print("<"+ ", ".join(answer) + ">")
