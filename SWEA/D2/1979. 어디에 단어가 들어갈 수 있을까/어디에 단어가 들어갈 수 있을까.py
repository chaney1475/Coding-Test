
def check_len():

    cnt = 0
    #가로로 세기

    for i in range(N):
        j = 0
        leng = 0
        while j < N:
            if A[i][j] == 1:
                leng += 1
            else:
                if leng == K:
                    cnt+=1
                leng = 0
            j+=1
        if leng == K:
            cnt +=1


    for j in range(N):
        i = 0
        leng = 0
        while i < N:
            if A[i][j] == 1:
                leng += 1
            else:
                if leng == K:
                    cnt += 1
                leng = 0
            i += 1
        if leng == K:
            cnt+=1


    return cnt


for t in range(1, int(input())+1):
    N, K = map(int, input().split())
    A = []

    for _ in range(N):
        A.append(list(map(int, input().split())))

    cnt = check_len()
    print(f"#{t} {cnt}")