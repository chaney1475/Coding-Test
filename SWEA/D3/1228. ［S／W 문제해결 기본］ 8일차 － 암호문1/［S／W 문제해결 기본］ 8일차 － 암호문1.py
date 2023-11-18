#암호문
for test_case in range(1, 11):

    #암호문의 길이
    N = int(input())
    A = list(map(int, input().split()))

    M = int(input())
    raw = list(input().split())
    order = []
    i = 0
    while i < len(raw) :
        if raw[i] == "I":
            nums = []
            i += 1
            index = raw[i]
            i += 1
            length = int(raw[i])
            i += 1
            for _ in range(length):
                nums.append(raw[i])
                i += 1
            order.append([index,nums])

    for j in range(M):
        pos = int(order[j][0])
        l = order[j][1]
        A = A[0:pos] + l + A[pos:]

    print(f"#{test_case}", end=" ")
    for k in range(0,10):
        print(A[k], end=" ")
    print()

