#sum

for test_case in range(1, 11):
    N = int(input())

    A = []
    for i in range(0, 100):
        A.append(list(map(int, input().split())))

    max_s = 0
    for i in range(0,100):
        temp = sum(A[i])
        if temp > max_s:
            max_s = temp

    for i in range(0,100):
        temp = 0
        for j in range(0,100):
            temp += A[j][i]
        if temp > max_s:
            max_s = temp
    temp = 0
    for i in range(0, 100):
        temp += A[i][i]
    if temp > max_s:
        max_s = temp

    print(f"#{N} {max_s}")