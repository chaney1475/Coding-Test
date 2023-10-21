import sys

input = sys.stdin.readline
# k번째 수
N, k = map(int, input().split())
A = list(map(int, input().split()))


def quickSort(S, E, k):
    global A
    if S < E:
        pivot = partition(S, E)
        if pivot == k:
            return
        elif pivot < k:
            quickSort(pivot + 1, E, k)
        else:
            quickSort(S, pivot - 1, k)


def swap(S, E):
    A[S], A[E] = A[E], A[S]


def partition(S, E):
    global A

    if S + 1 == E:
        if A[S] > A[E]:
            swap(S, E)
        return E
    M = (S + E) // 2
    swap(S, M)
    pivot = A[S]
    i = S + 1
    j = E
    

    while i <= j:
        while pivot < A[j] and j > 0:
            j -= 1
        while pivot > A[i] and i < len(A) - 1:
            i += 1
        if i <= j:
            swap(i, j)
            i = i + 1
            j = j - 1
    A[S] = A[j] #나눠진 경계의 왼쪽에 j가 있으므로  맨 왼쪽으로 작은수를 옮김
    A[j] = pivot #작은쪽의 맨 오른쪽 값인 j에 pivot을 넣어 정렬
    return j #피봇의 인덱스


quickSort(0, N - 1, k - 1)
print(A[k - 1])


