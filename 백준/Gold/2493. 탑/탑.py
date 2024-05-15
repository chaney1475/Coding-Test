import sys
input = sys.stdin.readline

N = int(input())
top = list(map(int, input().split()))
answer = [0] * N
stack = []

for i in range(N-1, -1, -1):
    while len(stack) > 0 and top[stack[-1]] < top[i]:
        answer[stack.pop()] = i+1
    stack.append(i)

print(*answer)