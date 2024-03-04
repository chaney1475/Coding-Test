import sys

input = sys.stdin.readline

N = int(input())

L = []

max_h = 0

for _ in range(N):
    a, b = map(int, input().split())
    max_h = max(max_h,b)
    L.append((a, b))

L.sort()
top = L[-1]



total = 0


r_max = 0
l_max = N-1

top = L[0] #0이 인덱스 1이 길이

for i in range(1, N):
    if L[i][1] > top[1]:
        total += (L[i][0] - top[0]) * top[1]
        top = L[i]
    if L[i][1] == max_h:
        r_max = i
        break
if L[0][1] == max_h:
    r_max = 0

top2 = L[-1]
for i in range(N-2, -1,-1):
    if L[i][1] > top2[1]:
        total += (top2[0] - L[i][0]) * top2[1]
        top2 = L[i]

    if L[i][1] == max_h:
        l_max = i
        break
if L[-1][1] == max_h:
    l_max = N-1

if L[0][1] == L[-1][1] == max_h:
    print(N*max_h)
else:
    total += ((L[l_max][0] - L[r_max][0] + 1) * (max_h))
    print(total)

