t = int(input())


def check():
    # 현재 초수에 가능한 량
    # 사람수가 팔린양 -> i
    for i in range(N):
        made = (A[i] // M) * K
        if made - (i + 1) < 0:
            return False
    return True


for test_case in range(1, t + 1):

    # 사람수, M초 후 K개
    N, M, K = map(int, input().split())
    # 도착시간
    A = list(map(int, input().split()))

    A.sort()

    if check():
        print(f"#{test_case} Possible")
    else:
        print(f"#{test_case} Impossible")
