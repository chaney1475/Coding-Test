test_case = int(input())


for i in range(test_case):
    s = 0
    A = [int(c) for c in input()]
    flag = 0
    for a in A:
        if a != flag:
            s += 1
            flag = a
    print(f"#{i+1} {s}")