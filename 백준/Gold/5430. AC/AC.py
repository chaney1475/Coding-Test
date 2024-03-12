import sys


input = sys.stdin.readline

N = int(input())

def check(d_list, l):
    r = 0
    D = []

    for i in range(len(d_list)):
        if d_list[i] == 'R':
            r += 1
        else:
            if r % 2 == 0:
                D.append(0)
            else:
                D.append(-1)

    for i in range(len(D)):
        if len(l) == 0:
            print("error")
            return
        l.pop(D[i])

    if r % 2 == 1:
        l = l[::-1]
        print("[",end="")
        for i in range(len(l)):
            print(l[i], end="")
            if i != len(l)-1:
                print(",", end="")
        print("]")

    else:
        print("[", end="")
        for i in range(len(l)):
            print(l[i], end="")
            if i != len(l)-1:
                print(",", end="")
        print("]")


for _ in range(N):
    do = input().rstrip()
    n = int(input())

    #리스트
    s = input().rstrip()
    lst = []
    if len(s) > 2:
        lst = [int(i) for i in s[1:-1].split(',')]

    check(do, lst)
