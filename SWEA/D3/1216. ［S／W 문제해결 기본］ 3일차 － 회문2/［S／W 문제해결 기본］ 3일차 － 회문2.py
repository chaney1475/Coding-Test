T = 10

def check(a):
    global longest
    start, end = 0, len(a)-1
    while start <= end:
        if a[start] != a[end]:
            return
        start += 1
        end -= 1

    if longest < len(a):
        longest = len(a)


def palindrome():
    #시작 끝
    for i in range(100):
        for s in range(100):
            for e in range(s+longest, 100):
                if A[i][s] == A[i][e]:
                    check(A[i][s:e+1])

    for i in range(100):
        for s in range(100):
            for e in range(s+longest, 100):
                if A[s][i] == A[e][i]:
                    tmp = []
                    for j in range(s,e+1):
                        tmp.append(A[j][i])
                    check(tmp)


for t in range(1,T+1):
    t = int(input())
    A = []
    for _ in range(100):
        A.append(list(input().rstrip()))

    longest = 0
    palindrome()
    print(f"#{t} {longest}")
