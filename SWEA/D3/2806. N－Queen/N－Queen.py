def check(x):
    for i in range(x):
        if row[i] == row[x] or abs(row[i] - row[x]) == x - i:
            return False
    return True


def dfs(x):
    global result
    #x는 현재 고른 행의 값 그 열의 값을 row[x]에 저장
    if x == N:
        result += 1
    else:
        for i in range(N):
            row[x] = i
            if check(x):
                dfs(x+1)
    
    
test_case = int(input())
for i in range(test_case):
    N = int(input())
    row = [0] * N # 초기화 행이 인덱스 열이 값

    result = 0 # 가능한 갯수
    dfs(0)#백트랙킹

    print(f"#{i+1} {result}")
