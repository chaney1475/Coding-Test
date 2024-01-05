import sys
input = sys.stdin.readline

t_case = int(input())

for t in range(t_case):
    A, B = map(int, input().split())
    result = A * B
    while A % B != 0:
        A = A % B
        if A < B:
            A, B = B, A
    #최소 공배수 구함
    result = result // B
    print(result)
