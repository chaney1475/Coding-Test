import sys
input = sys.stdin.readline
sys.setrecursionlimit(10000000)

N, M = map(int, input().split())
A = list(map(int, input().split()))
A.sort()

cnt = 0

def dfs(last, temp):
    global cnt
    if last != -1 and temp == M:
        cnt += 1
    for i in range(last+1,len(A)):
        dfs(i,temp + A[i])

dfs(-1,0)
print(cnt)