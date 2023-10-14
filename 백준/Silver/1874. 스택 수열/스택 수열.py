import sys
input = sys.stdin.readline

N = int(input())
A = [0] * N

for i in range(N):
    A[i] = int(input())

stack = []
answer = ""
result = True
num = 1

for a in A:
    if a >= num:
        while a >= num:
            stack.append(num)
            answer += "+\n"
            num += 1
        stack.pop()
        answer += "-\n"
    else:
        if stack.pop() != a:
            print("NO")
            result = False
            break
        else:
            answer += "-\n"
if result:
    print(answer)
