#369

N = int(input())


for i in range(1, N+1):
    flag = 0
    a = ""
    for k in str(i):
        if int(k) % 3 == 0 and int(k) != 0:
            a += "-"
            flag = 1
    if flag == 0:
        print(i, end=" ")
    else:
        print(a, end=" ")
