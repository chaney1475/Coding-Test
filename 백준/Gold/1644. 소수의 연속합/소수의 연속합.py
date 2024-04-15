import sys
input = sys.stdin.readline

N = int(input())

A = [i for i in range(N+1)]

for i in range(2,N+1):
    if A[i] == 0:
        continue
    for j in range(i+i,N+1,i):
        A[j] = 0

def make_sum():
    a = set(A)
    a.remove(0)
    a.remove(1)

    a = list(a)
    a.sort()

    s = 0
    e = 0
    temp = a[0]
    cnt = 0
    while e < len(a):
        if temp < N:
            e += 1
            if e == len(a):
                break
            temp += a[e]
        elif temp > N:
            temp -= a[s]
            s += 1
        else:
            cnt += 1
            temp -= a[s]
            s += 1
    return cnt

if N == 1:
    print(0)
else:
    print(make_sum())
