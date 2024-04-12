import sys
input = sys.stdin.readline

#길이, 합
N, M = map(int, input().split())
A = list(map(int, input().split()))

start = 0
end = 0
temp = A[0]
ans = sys.maxsize

while end < N:
    if temp < M:
        end += 1
        if end == N:
            continue
        temp += A[end]
    elif temp >= M:
        ans = min(ans,end - start +1)
        temp -= A[start]
        start += 1

if ans == sys.maxsize:
    print(0)
else:
    print(ans)