import sys
input = sys.stdin.readline

N = input().rstrip()
A = []
for i in N:
    A.append(int(i))

for i in range(len(A)):
    index = i
    for j in range(i+1, len(A)):
        if A[index] < A[j]:
            index = j
    A[index], A[i] = A[i], A[index]

for i in A:
    print(i,end='')