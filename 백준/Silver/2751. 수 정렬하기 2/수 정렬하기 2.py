import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**7)
N = int(input())
A = []
for i in range(N):
    A.append(int(input().rstrip()))


def merge(s, e):

    global A
    if e - s < 1: return

    m = (s + e) // 2  # 시작 끝 중간점
    merge(s, m)
    merge(m + 1, e)

    tmp = [] * (e - s + 1)

    index1 = s
    index2 = m + 1

    while index1 <= m and index2 <= e:
        if A[index1] < A[index2]:
            tmp.append(A[index1])
            index1 += 1
        else:
            tmp.append(A[index2])
            index2 += 1

    while index1 <= m:
        tmp.append(A[index1])
        index1 += 1

    while index2 <= e:
        tmp.append(A[index2])
        index2 += 1

    for i in range(s, e + 1):
        A[i] = tmp[i - s]


merge(0, N - 1)
print(*A)
