T = int(input())

for t in range(1,T+1):
    N = int(input())
    A = list(map(int, input().split()))
    max_num = [0] * N

    biggest = A[-1]

    for i in range(N-1,-1,-1):
        if A[i] > biggest:
            biggest = A[i]
        max_num[i] = biggest

    total = 0

    for i in range(N):
        total += (max_num[i] - A[i])

    print(f"#{t} {total}")