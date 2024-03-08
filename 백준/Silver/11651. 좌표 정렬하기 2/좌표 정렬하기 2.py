import sys
input= sys.stdin.readline

N = int(input())
A = []
for i in range(N):

    a,b = map(int, input().split())

    A.append([a,b])

sorted_list = sorted(A, key=lambda x: (x[1], x[0]))

for a,b in sorted_list:
    print(a,b)
