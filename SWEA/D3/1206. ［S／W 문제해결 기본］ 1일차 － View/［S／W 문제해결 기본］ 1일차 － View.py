lists = []

for j in range(10):
    answer = 0
    N = int(input())
    Building = list(map(int, input().split()))
    A = [] # 1차이
    B = [] # 2차이

    for i in range(N-1):
        A.append(Building[i] - Building[i+1])
        if i < N - 2:
            B.append(Building[i] - Building[i+2])

    for i in range(2, N-2):
        a = -A[i-1]
        b = A[i]
        c = -B[i-2]
        d = B[i]
        if a > 0 and b > 0 and c > 0 and d > 0:
            answer += min(a, b, c, d)
    lists.append(answer)

for i in range(10):
    print(f"#{i+1} {lists[i]}")