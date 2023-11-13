#농작물 수확
def cal():
    sum = 0
    mid = N // 2
    for l in range(mid):
        for m in range(mid-l, mid+l + 1):
            sum += A[l][m]

    for l in range(mid, N):
        for m in range(mid - (mid*2 - l), mid + (mid*2 - l) + 1):
            sum += A[l][m]

    return sum

test_case = int(input())

for i in range(test_case):
    N = int(input())
    A = []
    for j in range(N):
        A.append([int(c) for c in input()])

    print(f"#{i+1} {cal()}")
