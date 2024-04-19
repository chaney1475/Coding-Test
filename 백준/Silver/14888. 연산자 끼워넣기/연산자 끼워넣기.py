import sys
input = sys.stdin.readline

N = int(input())
num = list(map(int, input().split()))
cal = list(map(int, input().split()))

min_answer = sys.maxsize
max_answer = -sys.maxsize

def dfs(temp, i):
    global min_answer
    global max_answer
    if i == N:
        max_answer = max(temp, max_answer)
        min_answer = min(temp, min_answer)
        return
    if cal[0] > 0:
        cal[0] -= 1
        dfs(temp + num[i], i+1)
        cal[0] += 1
    if cal[1] > 0:
        cal[1] -= 1
        dfs(temp - num[i], i+1)
        cal[1] += 1
    if cal[2] > 0:
        cal[2] -= 1
        dfs(temp * num[i], i+1)
        cal[2] += 1
    if cal[3] > 0:
        cal[3] -= 1
        if temp < 0:
            dfs( -(abs(temp) // num[i]), i +1)
        else:
            dfs(temp // num[i], i+1)
        cal[3] += 1

dfs(num[0],1)

print(max_answer)
print(min_answer)