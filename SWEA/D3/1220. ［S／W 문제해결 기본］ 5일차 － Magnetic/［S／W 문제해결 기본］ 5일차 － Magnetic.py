T = 10
def check(lst):
    while len(lst) > 0 and lst[0] == 2:
        lst.pop(0)

    while len(lst) > 0 and lst[-1] == 1:
        lst.pop(-1)

    if len(lst) == 0:
        return 0
    before = lst[0]
    cnt = 0
    for ii in range(1,len(lst)):
        if before != lst[ii]:
            cnt += 1
        before = lst[ii]
    return (cnt + 1) // 2

def magnetic():
    cnt = 0
    for i in range(100):
        l = []
        for j in range(100):
            if A[j][i] != 0:
                l.append(A[j][i])
        cnt += check(l)

    return cnt


for t in range(1,T+1):
    A = []
    N = input()
    for _ in range(100):
        A.append(list(map(int, input().split())))

    answer = magnetic()
    print(f"#{t} {answer}")